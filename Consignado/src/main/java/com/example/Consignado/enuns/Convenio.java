package com.example.consignado.enuns;

import java.math.BigDecimal;

public enum Convenio {
    EP(new BigDecimal("0.026")), // 2.6%
    OP(new BigDecimal("0.022")),    // 2.2%
    INSS(new BigDecimal("0.016"));             // 1.6%

    private BigDecimal taxaJuros;

    Convenio(BigDecimal taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public BigDecimal getTaxaJuros() {
        return taxaJuros;
    }
    public String getNome() {
        return this.name();
    }
}
