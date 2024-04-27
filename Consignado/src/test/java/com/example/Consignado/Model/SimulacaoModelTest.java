package com.example.Consignado.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.time.LocalDate;

public class SimulacaoModelTest {

    @Test
    public void testId() {
        SimulacaoModel simulacao = new SimulacaoModel();
        simulacao.setId(1L);
        assertEquals(1L, simulacao.getId());
    }

    @Test
    public void testDataSimulacao() {
        SimulacaoModel simulacao = new SimulacaoModel();
        LocalDate date = LocalDate.now();
        simulacao.setDataSimulacao(date);
        assertEquals(date, simulacao.getDataSimulacao());
    }

    @Test
    public void testCpf() {
        SimulacaoModel simulacao = new SimulacaoModel();
        simulacao.setCpf("12345678901");
        assertEquals("12345678901", simulacao.getCpf());
    }

    @Test
    public void testConvenioCliente() {
        SimulacaoModel simulacao = new SimulacaoModel();
        simulacao.setConvenioCliente("Convenio Teste");
        assertEquals("Convenio Teste", simulacao.getConvenioCliente());
    }

    @Test
    public void testValorSolicitado() {
        SimulacaoModel simulacao = new SimulacaoModel();
        BigDecimal valor = new BigDecimal("1000.00");
        simulacao.setValorSolicitado(valor);
        assertEquals(valor, simulacao.getValorSolicitado());
    }

    @Test
    public void testTaxaAplicada() {
        SimulacaoModel simulacao = new SimulacaoModel();
        BigDecimal taxa = new BigDecimal("0.05");
        simulacao.setTaxaAplicada(taxa);
        assertEquals(taxa, simulacao.getTaxaAplicada());
    }

    @Test
    public void testQuantidadeParcelas() {
        SimulacaoModel simulacao = new SimulacaoModel();
        simulacao.setQuantidadeParcelas(12);
        assertEquals(12, simulacao.getQuantidadeParcelas());
    }

    @Test
    public void testValorTotal() {
        SimulacaoModel simulacao = new SimulacaoModel();
        BigDecimal valor = new BigDecimal("1200.00");
        simulacao.setValorTotal(valor);
        assertEquals(valor, simulacao.getValorTotal());
    }

    @Test
    public void testValorParcela() {
        SimulacaoModel simulacao = new SimulacaoModel();
        BigDecimal valor = new BigDecimal("100.00");
        simulacao.setValorParcela(valor);
        assertEquals(valor, simulacao.getValorParcela());
    }

    @Test
    public void testSegmento() {
        SimulacaoModel simulacao = new SimulacaoModel();
        simulacao.setSegmento("Segmento Teste");
        assertEquals("Segmento Teste", simulacao.getSegmento());
    }
}