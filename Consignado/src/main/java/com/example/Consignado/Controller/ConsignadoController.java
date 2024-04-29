package com.example.consignado.controller;


import com.example.consignado.util.LoggerFormatter;
import com.example.consignado.model.dto.request.ConsignadoRequestDTO;
import com.example.consignado.model.dto.request.SimulacaoRequestDTO;
import com.example.consignado.model.dto.response.ClienteResponseDTO;
import com.example.consignado.model.dto.response.ConsignadoResponseDTO;
import com.example.consignado.model.dto.response.SimulacaoResponseDTO;
import com.example.consignado.service.ConsignadoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.extern.java.Log;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v0/consignado")
@Log
public class ConsignadoController {

    @Autowired
    ConsignadoService consignadoService;

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteResponseDTO>> listarClientes() {
        String correlationId = LoggerFormatter.generateCorrelationId();
        log.info("Recebida solicitação para listar clientes. - " + correlationId);
        List<ClienteResponseDTO> clientes = consignadoService.listarClientes();
        log.info("Clientes listados com sucesso - " + correlationId);
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
        log.info("Recebida solicitação para listar simulações com base no CPF: " + cpf + " - "+ correlationId);
        List<SimulacaoResponseDTO> simulacoes = consignadoService.listarSimulacoesPorCPF(cpf);
        log.info("Simulações listadas com sucesso." + correlationId);
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
        log.info("Recebida solicitação para listar consignados com base no CPF: " + cpf + " - "+ correlationId);
        List<ConsignadoResponseDTO> consignados = consignadoService.listarConsignadosPorCPF(cpf);
        log.info("Consignados listados com sucesso." + correlationId);
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
        log.info("Recebida solicitação para obter cliente com CPF: " + cpf + " - "+ correlationId);
        ClienteResponseDTO clienteResponseDTO= consignadoService.buscarCliente(cpf);
        log.info("Cliente obtido com sucesso. - " + correlationId);
        return ResponseEntity.ok(clienteResponseDTO);
    }

    @PostMapping("/simulacao")
    public ResponseEntity<SimulacaoResponseDTO> simulacao(@Valid @RequestBody SimulacaoRequestDTO request){
        String correlationId = LoggerFormatter.generateCorrelationId();
        log.info("Recebida solicitação para realizar simulação com o CPF: " + request.getCpf() + " - " + correlationId);
        SimulacaoResponseDTO simulacaoResponseDTO = consignadoService.simulacao(request);
        log.info("Simulação realizada com sucesso - " + correlationId);
        return ResponseEntity.ok(simulacaoResponseDTO);
    }

    @PostMapping("/contratar")
    public ResponseEntity<ConsignadoResponseDTO> contratacao(@Valid @RequestBody ConsignadoRequestDTO requestDTO){
        String correlationId = LoggerFormatter.generateCorrelationId();
        log.info("Recebida solicitação para contratar consignado." + requestDTO.getCpf() + " - " + correlationId);
        ConsignadoResponseDTO consignadoResponseDTO = consignadoService.consigando(requestDTO);
        log.info("Consignado contratado com sucesso." + correlationId);
        return ResponseEntity.ok(consignadoResponseDTO);
    }

}
