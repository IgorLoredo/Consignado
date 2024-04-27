package com.example.Consignado.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "CONSIGNADO")
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDataContrato(LocalDate dataContrato) {
        this.dataContrato = dataContrato;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public void setConvenioCliente(String convenioCliente) {
        this.convenioCliente = convenioCliente;
    }

    public void setValorSolicitado(BigDecimal valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
    }

    public void setTaxaAplicada(BigDecimal taxaAplicada) {
        this.taxaAplicada = taxaAplicada;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setValorParcela(BigDecimal valorParcela) {
        this.valorParcela = valorParcela;
    }

    public LocalDate getDataContrato() {
        return dataContrato;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public String getConvenioCliente() {
        return convenioCliente;
    }

    public BigDecimal getValorSolicitado() {
        return valorSolicitado;
    }

    public BigDecimal getTaxaAplicada() {
        return taxaAplicada;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public BigDecimal getValorParcela() {
        return valorParcela;
    }


}
