// FILEPATH: /c:/Users/Igor Loredo/Documents/projetos Java/Consignado/src/test/java/com/example/Consignado/Model/ConsignadoModelTest.java

package com.example.Consignado.Model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsignadoModelTest {

    @Test
    public void testSetAndGetId() {
        ConsignadoModel consignadoModel = new ConsignadoModel();
        consignadoModel.setId(1L);
        assertEquals(1L, consignadoModel.getId());
    }

    @Test
    public void testSetAndGetDataContrato() {
        ConsignadoModel consignadoModel = new ConsignadoModel();
        LocalDate date = LocalDate.now();
        consignadoModel.setDataContrato(date);
        assertEquals(date, consignadoModel.getDataContrato());
    }

    @Test
    public void testSetAndGetCpfCliente() {
        ConsignadoModel consignadoModel = new ConsignadoModel();
        consignadoModel.setCpfCliente("12345678901");
        assertEquals("12345678901", consignadoModel.getCpfCliente());
    }

    @Test
    public void testSetAndGetConvenioCliente() {
        ConsignadoModel consignadoModel = new ConsignadoModel();
        consignadoModel.setConvenioCliente("Convenio");
        assertEquals("Convenio", consignadoModel.getConvenioCliente());
    }

    @Test
    public void testSetAndGetValorSolicitado() {
        ConsignadoModel consignadoModel = new ConsignadoModel();
        BigDecimal valorSolicitado = new BigDecimal("1000.00");
        consignadoModel.setValorSolicitado(valorSolicitado);
        assertEquals(valorSolicitado, consignadoModel.getValorSolicitado());
    }

    @Test
    public void testSetAndGetTaxaAplicada() {
        ConsignadoModel consignadoModel = new ConsignadoModel();
        BigDecimal taxaAplicada = new BigDecimal("5.00");
        consignadoModel.setTaxaAplicada(taxaAplicada);
        assertEquals(taxaAplicada, consignadoModel.getTaxaAplicada());
    }

    @Test
    public void testSetAndGetQuantidadeParcelas() {
        ConsignadoModel consignadoModel = new ConsignadoModel();
        consignadoModel.setQuantidadeParcelas(12);
        assertEquals(12, consignadoModel.getQuantidadeParcelas());
    }

    @Test
    public void testSetAndGetValorTotal() {
        ConsignadoModel consignadoModel = new ConsignadoModel();
        BigDecimal valorTotal = new BigDecimal("12000.00");
        consignadoModel.setValorTotal(valorTotal);
        assertEquals(valorTotal, consignadoModel.getValorTotal());
    }

    @Test
    public void testSetAndGetValorParcela() {
        ConsignadoModel consignadoModel = new ConsignadoModel();
        BigDecimal valorParcela = new BigDecimal("1000.00");
        consignadoModel.setValorParcela(valorParcela);
        assertEquals(valorParcela, consignadoModel.getValorParcela());
    }
}