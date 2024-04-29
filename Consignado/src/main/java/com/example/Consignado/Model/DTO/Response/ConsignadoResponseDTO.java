package com.example.consignado.model.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ConsignadoResponseDTO {

    private LocalDate dataContrato;
    private String cpfCliente;
    private String convenioCliente;
    private BigDecimal valorSolicitado;
    private BigDecimal taxaAplicada;
    private int quantidadeParcelas;
    private BigDecimal valorTotal;
    private BigDecimal valorParcela;
    private long idSimulacao;

    // Construtor vazio
    public ConsignadoResponseDTO() {
    }

    // Construtor com todos os atributos
    public ConsignadoResponseDTO( LocalDate dataContrato, String cpfCliente, String convenioCliente,
                                 BigDecimal valorSolicitado, BigDecimal taxaAplicada, int quantidadeParcelas,
                                 BigDecimal valorTotal, BigDecimal valorParcela) {
        this.dataContrato = dataContrato;
        this.cpfCliente = cpfCliente;
        this.convenioCliente = convenioCliente;
        this.valorSolicitado = valorSolicitado;
        this.taxaAplicada = taxaAplicada;
        this.quantidadeParcelas = quantidadeParcelas;
        this.valorTotal = valorTotal;
        this.valorParcela = valorParcela;
    }

    public ConsignadoResponseDTO(long id, String cpfCliente, String convenioCliente, BigDecimal valorTotal) {
        this.cpfCliente = cpfCliente;
        this.convenioCliente = convenioCliente;
        this.valorTotal = valorTotal;
    }



}
