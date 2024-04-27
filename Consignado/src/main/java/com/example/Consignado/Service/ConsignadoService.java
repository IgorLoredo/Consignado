package com.example.Consignado.Service;


import com.example.Consignado.ExceptionHandler.ResourceNotFoundException;
import com.example.Consignado.Mapper.ClienteMapper;
import com.example.Consignado.Mapper.ConsignadoMapper;
import com.example.Consignado.Mapper.SimulacaoMapper;

import com.example.Consignado.Model.ClienteModel;
import com.example.Consignado.Model.ConsignadoModel;
import com.example.Consignado.Model.DTO.Request.ConsignadoRequestDTO;
import com.example.Consignado.Model.DTO.Request.SimulacaoRequestDTO;
import com.example.Consignado.Model.DTO.Response.ClienteResponseDTO;
import com.example.Consignado.Model.DTO.Response.ConsignadoResponseDTO;
import com.example.Consignado.Model.DTO.Response.SimulacaoResponseDTO;
import com.example.Consignado.Model.SimulacaoModel;
import com.example.Consignado.Repository.ClienteRepository;
import com.example.Consignado.Repository.ConsignadoRepository;
import com.example.Consignado.Repository.SimulacaoRepository;
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
            clienteModel.orElseThrow(() ->  new ResourceNotFoundException("Cliente não encontrado"));
            ClienteResponseDTO clienteResponseDTO = ClienteMapper.INSTANCE.modelToResponse(clienteModel.get());
            return clienteResponseDTO;
        } catch ( ResourceNotFoundException ex){
            System.out.println(ex);
            throw new ResourceNotFoundException(ex.getMessage());
        }
    }

    public SimulacaoResponseDTO simulacao(SimulacaoRequestDTO requestDTO){
        try {
            // validando cpf
            Optional<ClienteModel> clienteModel = clienteRepository.findByCpf(requestDTO.getCpf());
            clienteModel.orElseThrow(() ->  new ResourceNotFoundException("Cliente não encontrado para simulação"));

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
        Optional<SimulacaoModel> simulacaoModel = simulacaoRepository.findById(requestDTO.getIdConsigando());
        simulacaoModel.orElseThrow(() ->  new ResourceNotFoundException("Simulação não encontrada, por favor faça uma simulação antes"));

        ConsignadoModel consignadoModel = ConsignadoMapper.INSTANCE.simulacaoToConsignado(simulacaoModel.get());
        consignadoRepository.save(consignadoModel);
        simulacaoRepository.delete(simulacaoModel.get());
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
            clienteModel.orElseThrow(() ->  new ResourceNotFoundException("Cliente não encontrado"));
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
            clienteModel.orElseThrow(() ->  new ResourceNotFoundException("Cliente não encontrado"));

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



