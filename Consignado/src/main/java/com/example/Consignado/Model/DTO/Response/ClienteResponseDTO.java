package com.example.consignado.model.dto.response;


import com.example.consignado.enuns.Convenio;
import com.example.consignado.enuns.Segmento;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClienteResponseDTO {


    @JsonProperty("CPF")
    private String cpf;

    @JsonProperty("Nome")
    private String nome;

    @JsonProperty("Correntista")
    private String correntista;

    @JsonProperty("Segmento")
    private Segmento segmento;

    @JsonProperty("Convênio")
    private Convenio convenio;

    public ClienteResponseDTO() {
    }

    public ClienteResponseDTO(String cpf, String nome, String correntista, Segmento segmento, Convenio convenio) {
        this.cpf = cpf;
        this.nome = nome;
        this.correntista = correntista; // Considerando "email" como correntista neste contexto
        this.segmento = segmento;
        this.convenio = convenio;

    }
}