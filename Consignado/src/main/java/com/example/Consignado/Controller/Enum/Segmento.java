package com.example.Consignado.Controller.Enum;
import java.math.BigDecimal;

public enum Segmento {

    Varejo(12),
    Uniclass(36),
    Person(48),
    NAOCORRENTISTA(0);

    private int tempo;

    Segmento(int tempo) {
       this.tempo = tempo;
    }

    public int getTempo() {
        return tempo;
    }


    public String getNome() {
        return this.name();
    }
}