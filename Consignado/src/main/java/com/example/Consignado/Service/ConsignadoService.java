package com.example.consignado.service;


import com.example.consignado.mapper.ClienteMapper;
import com.example.consignado.mapper.ConsignadoMapper;
import com.example.consignado.mapper.SimulacaoMapper;

import com.example.consignado.model.ClienteModel;
import com.example.consignado.model.ConsignadoModel;
import com.example.consignado.model.dto.request.ConsignadoRequestDTO;
import com.example.consignado.model.dto.request.SimulacaoRequestDTO;
import com.example.consignado.model.dto.response.ClienteResponseDTO;
import com.example.consignado.model.dto.response.ConsignadoResponseDTO;
import com.example.consignado.model.dto.response.SimulacaoResponseDTO;
import com.example.consignado.model.SimulacaoModel;
import com.example.consignado.repository.ClienteRepository;
import com.example.consignado.repository.ConsignadoRepository;
import com.example.consignado.repository.SimulacaoRepository;
import com.example.consignado.service.Exception.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ConsignadoService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private SimulacaoRepository simulacaoRepository;

    @Autowired
    private ConsignadoRepository consignadoRepository;

    public ClienteResponseDTO buscarCliente(String cpf) {
        try {
            System.out.println(cpf);
            Optional<ClienteModel> clienteModel = clienteRepository.findByCpf(cpf);
            clienteModel.orElseThrow(() ->  new DatabaseException.ResourceNotFoundException("Cliente não encontrado"));
            ClienteResponseDTO clienteResponseDTO = ClienteMapper.INSTANCE.modelToResponse(clienteModel.get());
            return clienteResponseDTO;
        } catch ( DatabaseException.ResourceNotFoundException ex){
            System.out.println(ex);
            throw new DatabaseException.ResourceNotFoundException(ex.getMessage());
        }
    }

    public SimulacaoResponseDTO simulacao(SimulacaoRequestDTO requestDTO){
        try {
            // validando cpf
            Optional<ClienteModel> clienteModel = clienteRepository.findByCpf(requestDTO.getCpf());
            clienteModel.orElseThrow(() ->  new DatabaseException.ResourceNotFoundException("Cliente não encontrado para simulação"));

            BigDecimal taxa;
            switch (clienteModel.get().getConvenio().toUpperCase()) {
                case "EP":
                    taxa = new BigDecimal("0.026"); // 2.6%
                    break;
                case "OP":
                    taxa = new BigDecimal("0.022"); // 2.2%
                    break;
                case "INSS":
                    taxa = new BigDecimal("0.016"); // 1.6%
                    break;
                default:
                    throw new RuntimeException("Convênio inválido");
            }
            // Aplicar desconto para clientes correntistas
            if ("S".equalsIgnoreCase(clienteModel.get().getCorrentista())) {
                taxa = taxa.multiply(new BigDecimal("0.95")); // 5% de desconto
            }

            int parcelasMaximas;
             String segmento = clienteModel.get().getSegmento().toUpperCase(Locale.ROOT);
            parcelasMaximas = switch (segmento != null ? segmento : "") {
                case "VAREJO" -> 24;
                case "UNICLASS" -> 36;
                case "PERSON" -> 48;
                default -> 12; // Não correntistas
            };

            if (requestDTO.getQuantParcelas() > parcelasMaximas) {
                throw new RuntimeException("Quantidade de parcelas excede o limite permitido para o segmento do cliente");
            }
            BigDecimal valorTotal = requestDTO.getValorSolicitado()
                    .multiply(BigDecimal.ONE.
                            add(taxa.multiply(BigDecimal.valueOf(requestDTO.getQuantParcelas()))));

            BigDecimal valorParcela = valorTotal.divide(BigDecimal.valueOf(requestDTO.getQuantParcelas()), 2, RoundingMode.HALF_UP);

            // Criar e salvar a simulação
            SimulacaoModel simulacao = new SimulacaoModel();
            populateSimulacao(simulacao, requestDTO, clienteModel, taxa, valorTotal, valorParcela);

            simulacaoRepository.save(simulacao);

            SimulacaoResponseDTO simulacaoResponseDTO = SimulacaoMapper.INSTANCE.modelToResponse(simulacao);
            return simulacaoResponseDTO;
        }catch (Exception ex){

            throw ex;
        }
    }

    public ConsignadoResponseDTO consigando(ConsignadoRequestDTO requestDTO){
        try {
        Optional<SimulacaoModel> simulacaoModel = simulacaoRepository.findById(requestDTO.getId());
        simulacaoModel.orElseThrow(() ->  new DatabaseException.ResourceNotFoundException("Simulação não encontrada, por favor faça uma simulação antes"));

        ConsignadoModel consignadoModel = ConsignadoMapper.INSTANCE.simulacaoToConsignado(simulacaoModel.get());
        consignadoRepository.save(consignadoModel);

        ConsignadoResponseDTO responseDTO = ConsignadoMapper.INSTANCE.modelToResponse(consignadoModel);
        return responseDTO;
        } catch (Exception ex) {
            throw ex;
        }
    }

    // Método para listar todos os clientes da base
    public List<ClienteResponseDTO> listarClientes() {
        try{
            List<ClienteModel> clientes = clienteRepository.findAll();
            return ClienteMapper.INSTANCE.modelsToResponse(clientes);
        } catch (Exception ex) {
            System.out.println(ex);
            throw ex;
        }
    }

    // Método para listar todas as simulações com base no CPF do cliente
    public List<SimulacaoResponseDTO> listarSimulacoesPorCPF(String cpf) {
        try{
            Optional<ClienteModel> clienteModel = clienteRepository.findByCpf(cpf);
            clienteModel.orElseThrow(() ->  new DatabaseException.ResourceNotFoundException("Cliente não encontrado"));
            System.out.println("igorrr");
            List<SimulacaoModel> simulacoes = simulacaoRepository.findAllByCpf(clienteModel.get().getCpf());
            return SimulacaoMapper.INSTANCE.modelsToResponse(simulacoes);

        } catch (Exception ex) {
            throw ex;
        }
    }

    // Método para listar todos os consignados contratados com base no CPF do cliente
    public List<ConsignadoResponseDTO> listarConsignadosPorCPF(String cpf) {
        try{
            Optional<ClienteModel> clienteModel = clienteRepository.findByCpf(cpf);
            clienteModel.orElseThrow(() ->  new DatabaseException.ResourceNotFoundException("Cliente não encontrado"));

            List<ConsignadoModel> consignados = consignadoRepository.findByCpfCliente(clienteModel.get().getCpf());
            return ConsignadoMapper.INSTANCE.modelsToResponse(consignados);
        } catch (Exception ex) {
            throw ex;
        }
    }

    // Método para listar todos os consignados contratados com base no CPF do cliente
    public void populateSimulacao(SimulacaoModel simulacao, SimulacaoRequestDTO requestDTO, Optional<ClienteModel> clienteModel, BigDecimal taxa, BigDecimal valorTotal, BigDecimal valorParcela) {
        simulacao.setCpf(requestDTO.getCpf());
        simulacao.setDataSimulacao(LocalDate.now());
        simulacao.setConvenioCliente(clienteModel.get().getConvenio());
        simulacao.setValorSolicitado(requestDTO.getValorSolicitado());
        simulacao.setTaxaAplicada(taxa.multiply(new BigDecimal(10)));
        simulacao.setQuantidadeParcelas(requestDTO.getQuantParcelas());
        simulacao.setValorTotal(valorTotal);
        simulacao.setValorParcela(valorParcela);
    }
}



