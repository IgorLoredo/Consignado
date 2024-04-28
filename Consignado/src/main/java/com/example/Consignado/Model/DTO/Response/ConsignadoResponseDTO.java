package com.example.Consignado.Model.DTO.Response;

import java.math.BigDecimal;
import java.time.LocalDate;

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


    // Getters e setters

    public LocalDate getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(LocalDate dataContrato) {
        this.dataContrato = dataContrato;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
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

    public long getIdSimulacao() {
        return idSimulacao;
    }

    public void setIdSimulacao(long idSimulacao) {
        this.idSimulacao = idSimulacao;
    }

}
