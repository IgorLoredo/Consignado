package com.example.Consignado.Controller;


import com.example.Consignado.Logger.LoggerFormatter;
import com.example.Consignado.Model.DTO.Request.ConsignadoRequestDTO;
import com.example.Consignado.Model.DTO.Request.SimulacaoRequestDTO;
import com.example.Consignado.Model.DTO.Response.ClienteResponseDTO;
import com.example.Consignado.Model.DTO.Response.ConsignadoResponseDTO;
import com.example.Consignado.Model.DTO.Response.SimulacaoResponseDTO;
import com.example.Consignado.Service.ConsignadoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v0/consignado")
public class ConsignadoController {

    @Autowired
    ConsignadoService consignadoService;

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteResponseDTO>> listarClientes() {
        String correlationId = LoggerFormatter.generateCorrelationId();
        LoggerFormatter.logInfo("Recebida solicitação para listar clientes.", correlationId, ConsignadoController.class);

        List<ClienteResponseDTO> clientes = consignadoService.listarClientes();

        LoggerFormatter.logInfo("Clientes listados com sucesso.", correlationId, ConsignadoController.class);
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/simulacoes/{cpf}")
    public ResponseEntity<List<SimulacaoResponseDTO>> listarSimulacoesPorCPF(
            @PathVariable
            @CPF
            @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}",
                    message = "CPF deve estar no formato DDD.DDD.DDD-DD")
                    String cpf) {
        String correlationId = LoggerFormatter.generateCorrelationId();
        LoggerFormatter.logInfo("Recebida solicitação para listar simulações com base no CPF: " + cpf, correlationId, ConsignadoController.class);

        List<SimulacaoResponseDTO> simulacoes = consignadoService.listarSimulacoesPorCPF(cpf);

        LoggerFormatter.logInfo("Simulações listadas com sucesso.", correlationId, ConsignadoController.class);
        return ResponseEntity.ok(simulacoes);
    }

    @GetMapping("/consignados/{cpf}")
    public ResponseEntity<List<ConsignadoResponseDTO>> listarConsignadosPorCPF(
            @PathVariable
            @CPF
            @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}",
                    message = "CPF deve estar no formato DDD.DDD.DDD-DD")
                    String cpf) {
        String correlationId = LoggerFormatter.generateCorrelationId();
        LoggerFormatter.logInfo("Recebida solicitação para listar consignados com base no CPF: " + cpf, correlationId, ConsignadoController.class);

        List<ConsignadoResponseDTO> consignados = consignadoService.listarConsignadosPorCPF(cpf);

        LoggerFormatter.logInfo("Consignados listados com sucesso.", correlationId, ConsignadoController.class);
        return ResponseEntity.ok(consignados);
    }

    @GetMapping("/cliente/{cpf}")
    public ResponseEntity<ClienteResponseDTO> getCliente(
            @PathVariable
            @CPF
            @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}",
                    message = "CPF deve estar no formato DDD.DDD.DDD-DD")
                    String cpf){
        String correlationId = LoggerFormatter.generateCorrelationId();
        LoggerFormatter.logInfo("Recebida solicitação para obter cliente com CPF: " + cpf, correlationId, ConsignadoController.class);

        ClienteResponseDTO clienteResponseDTO= consignadoService.buscarCliente(cpf);

        LoggerFormatter.logInfo("Cliente obtido com sucesso.", correlationId, ConsignadoController.class);
        return ResponseEntity.ok(clienteResponseDTO);
    }

    @PostMapping("/simulacao")
    public ResponseEntity<SimulacaoResponseDTO> simulacao(@Valid @RequestBody SimulacaoRequestDTO request){
        String correlationId = LoggerFormatter.generateCorrelationId();
        LoggerFormatter.logInfo("Recebida solicitação para realizar simulação com o CPF: " + request.getCpf(), correlationId, ConsignadoController.class);

        SimulacaoResponseDTO simulacaoResponseDTO = consignadoService.simulacao(request);

        LoggerFormatter.logInfo("Simulação realizada com sucesso.", correlationId, ConsignadoController.class);
        return ResponseEntity.ok(simulacaoResponseDTO);
    }

    @PostMapping("/contratar")
    public ResponseEntity<ConsignadoResponseDTO> contratacao(@Valid @RequestBody ConsignadoRequestDTO requestDTO){
        String correlationId = LoggerFormatter.generateCorrelationId();
        LoggerFormatter.logInfo("Recebida solicitação para contratar consignado.", correlationId, ConsignadoController.class);

        ConsignadoResponseDTO consignadoResponseDTO = consignadoService.consigando(requestDTO);

        LoggerFormatter.logInfo("Consignado contratado com sucesso.", correlationId, ConsignadoController.class);
        return ResponseEntity.ok(consignadoResponseDTO);
    }

}
