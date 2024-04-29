package com.example.consignado.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "tb_simulacao")
@Data
public class SimulacaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate dataSimulacao;

    private String cpf;
    private String convenioCliente;
    private BigDecimal valorSolicitado;
    private BigDecimal taxaAplicada;
    private int quantidadeParcelas;
    private BigDecimal valorTotal;
    private BigDecimal valorParcela;
    private String segmento;

    public SimulacaoModel() {
    }

    public SimulacaoModel( LocalDate dataSimulacao, String cpfCliente, String convenioCliente,
                           BigDecimal valorSolicitado, BigDecimal taxaAplicada, int quantidadeParcelas,
                           BigDecimal valorTotal, BigDecimal valorParcela) {
        this.dataSimulacao = dataSimulacao;
        this.cpf = cpfCliente;
        this.convenioCliente = convenioCliente;
        this.valorSolicitado = valorSolicitado;
        this.taxaAplicada = taxaAplicada;
        this.quantidadeParcelas = quantidadeParcelas;
        this.valorTotal = valorTotal;
        this.valorParcela = valorParcela;
    }

}
