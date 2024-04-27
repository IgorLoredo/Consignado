package com.example.Consignado.Model;

import jakarta.persistence.*;


@Entity
@Table(name = "CLIENTE")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String cpf;

    private String nome;

    private String correntista;

    private String segmento;

    private String convenio;

    public ClienteModel() {
    }

    public ClienteModel(String cpf, String nome, String correntista, String segmento, String convenio) {
        this.cpf = cpf;
        this.nome = nome;
        this.correntista = correntista;
        this.segmento = segmento;
        this.convenio = convenio;
    }
    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public String getCorrentista() {
        return this.correntista;
    }

    public void setCorrentista(String correntista) {
        this.correntista = correntista;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }
}
