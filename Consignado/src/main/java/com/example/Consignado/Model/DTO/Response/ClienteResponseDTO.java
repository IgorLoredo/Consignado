package com.example.Consignado.Model.DTO.Response;


import com.example.Consignado.Controller.Enum.Convenio;
import com.example.Consignado.Controller.Enum.Segmento;
import com.fasterxml.jackson.annotation.JsonProperty;

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


    public Segmento getSegmento() {
        return segmento;
    }

    public void setSegmento(Segmento segmento) {
        this.segmento = segmento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public String getConsignado() {
        return correntista;
    }

    public void setConsignado(String consignado) {
        this.correntista = consignado;
    }

    public String getCorrentista() {
        return correntista;
    }

    public void setCorrentista(String correntista) {
        this.correntista = correntista;
    }

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