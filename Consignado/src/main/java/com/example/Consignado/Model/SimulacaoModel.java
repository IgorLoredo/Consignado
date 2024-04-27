package com.example.Consignado.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "SIMULACAO")
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataSimulacao() {
        return dataSimulacao;
    }

    public void setDataSimulacao(LocalDate dataSimulacao) {
        this.dataSimulacao = dataSimulacao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getConvenioCliente() {
        return convenioCliente;
    }

    public void setConvenioCliente(String convenioCliente) {
        this.convenioCliente = convenioCliente;
    }

    public BigDecimal getValorSolicitado() {
        return valorSolicitado;
    }

    public void setValorSolicitado(BigDecimal valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
    }

    public BigDecimal getTaxaAplicada() {
        return taxaAplicada;
    }

    public void setTaxaAplicada(BigDecimal taxaAplicada) {
        this.taxaAplicada = taxaAplicada;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(BigDecimal valorParcela) {
        this.valorParcela = valorParcela;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }
}
