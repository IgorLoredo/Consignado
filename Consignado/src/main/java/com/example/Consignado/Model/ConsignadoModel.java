package com.example.consignado.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_consignado")
@Data
public class ConsignadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDate dataContrato;
    private String cpfCliente;
    private String convenioCliente;
    private BigDecimal valorSolicitado;
    private BigDecimal taxaAplicada;
    private int quantidadeParcelas;
    private BigDecimal valorTotal;
    private BigDecimal valorParcela;
    private long idSimulacao;

    public ConsignadoModel() {
    }

    // Construtor com todos os atributos
    public ConsignadoModel(LocalDate dataContrato, String cpfCliente, String convenioCliente,
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
}
