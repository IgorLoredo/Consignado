package com.example.consignado.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class ConsignadoRequestDTO {

    @JsonProperty("CPF")
    @NotNull
    @NotEmpty
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato DDD.DDD.DDD-DD")
    @CPF(message="cpf inválido")
    private String cpf;

    @NotNull
    private long id;



}
