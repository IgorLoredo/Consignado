package com.example.Consignado.Model.DTO.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;


public class ConsignadoRequestDTO {

    @JsonProperty("CPF")
    @NotNull
    @NotEmpty
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato DDD.DDD.DDD-DD")
    @CPF(message="cpf inválido")
    private String cpf;

    @NotNull
    private long idConsigando;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public long getIdConsigando() {
        return idConsigando;
    }

    public void setIdConsigando(long idConsigando) {
        this.idConsigando = idConsigando;
    }

}
