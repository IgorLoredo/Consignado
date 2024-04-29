package com.example.consignado.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "tb_cliente")
@Data
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

}
