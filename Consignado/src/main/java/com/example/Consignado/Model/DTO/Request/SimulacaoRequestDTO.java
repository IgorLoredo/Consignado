package com.example.Consignado.Model.DTO.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public class SimulacaoRequestDTO {

    @JsonProperty("CPF")
    @NotNull
    @NotEmpty
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato DDD.DDD.DDD-DD")
    @CPF(message="cpf inválido")
    private String cpf;

    @NotNull(message="quantParcelas inválido")
    private int quantParcelas;


    @NotNull(message="valorSolicitado inválido")
    private BigDecimal valorSolicitado;

    public SimulacaoRequestDTO(String cpf, int quantParcelas, BigDecimal valorSolicitado) {
        this.cpf = cpf;
        this.quantParcelas = quantParcelas;
        this.valorSolicitado = valorSolicitado;
    }
    public SimulacaoRequestDTO() {
    }

    public BigDecimal getValorSolicitado() {
        return valorSolicitado;
    }

    public void setValorSolicitado(BigDecimal valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getQuantParcelas() {
        return quantParcelas;
    }

    public void setQuantParcelas(int quantParcelas) {
        this.quantParcelas = quantParcelas;
    }



}
