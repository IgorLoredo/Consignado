package com.example.Consignado.Model.DTO.Response;

import java.math.BigDecimal;
import java.time.LocalDate;

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



    // Getters e Setters
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
}
