package com.example.consignado.model.dto.response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulacaoResponseDTOTest {

    private SimulacaoResponseDTO simulacaoResponseDTO;

    @BeforeEach
    public void setUp() {
        simulacaoResponseDTO = new SimulacaoResponseDTO();
    }

    @Test
    public void testId() {
        long expected = 1L;
        simulacaoResponseDTO.setId(expected);
        assertEquals(expected, simulacaoResponseDTO.getId());
    }

    @Test
    public void testDataSimulacao() {
        LocalDate expected = LocalDate.now();
        simulacaoResponseDTO.setDataSimulacao(expected);
        assertEquals(expected, simulacaoResponseDTO.getDataSimulacao());
    }

    @Test
    public void testCpf() {
        String expected = "12345678901";
        simulacaoResponseDTO.setCpf(expected);
        assertEquals(expected, simulacaoResponseDTO.getCpf());
    }

    @Test
    public void testConvenioCliente() {
        String expected = "Convenio Teste";
        simulacaoResponseDTO.setConvenioCliente(expected);
        assertEquals(expected, simulacaoResponseDTO.getConvenioCliente());
    }

    @Test
    public void testValorSolicitado() {
        BigDecimal expected = new BigDecimal("1000.00");
        simulacaoResponseDTO.setValorSolicitado(expected);
        assertEquals(expected, simulacaoResponseDTO.getValorSolicitado());
    }

    @Test
    public void testTaxaAplicada() {
        BigDecimal expected = new BigDecimal("0.05");
        simulacaoResponseDTO.setTaxaAplicada(expected);
        assertEquals(expected, simulacaoResponseDTO.getTaxaAplicada());
    }

    @Test
    public void testQuantidadeParcelas() {
        int expected = 12;
        simulacaoResponseDTO.setQuantidadeParcelas(expected);
        assertEquals(expected, simulacaoResponseDTO.getQuantidadeParcelas());
    }

    @Test
    public void testValorTotal() {
        BigDecimal expected = new BigDecimal("1200.00");
        simulacaoResponseDTO.setValorTotal(expected);
        assertEquals(expected, simulacaoResponseDTO.getValorTotal());
    }

    @Test
    public void testValorParcela() {
        BigDecimal expected = new BigDecimal("100.00");
        simulacaoResponseDTO.setValorParcela(expected);
        assertEquals(expected, simulacaoResponseDTO.getValorParcela());
    }
}