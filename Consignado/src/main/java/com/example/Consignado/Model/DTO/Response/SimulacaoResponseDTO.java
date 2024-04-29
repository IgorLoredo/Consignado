package com.example.consignado.model.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class SimulacaoResponseDTO {
    private long id;
    private LocalDate dataSimulacao;
    private String cpf;
    private String convenioCliente;
    private BigDecimal valorSolicitado;
    private BigDecimal taxaAplicada;
    private int quantidadeParcelas;
    private BigDecimal valorTotal;
    private BigDecimal valorParcela;

    public SimulacaoResponseDTO() {
    }

    public SimulacaoResponseDTO(long id, LocalDate dataSimulacao, String cpf, String convenioCliente,
                                BigDecimal valorSolicitado, BigDecimal taxaAplicada, int quantidadeParcelas,
                                BigDecimal valorTotal, BigDecimal valorParcela) {
        this.id = id;
        this.dataSimulacao = dataSimulacao;
        this.cpf = cpf;
        this.convenioCliente = convenioCliente;
        this.valorSolicitado = valorSolicitado;
        this.taxaAplicada = taxaAplicada;
        this.quantidadeParcelas = quantidadeParcelas;
        this.valorTotal = valorTotal;
        this.valorParcela = valorParcela;
    }
}
