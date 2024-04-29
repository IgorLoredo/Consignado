package com.example.consignado.model.dto.response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsignadoResponseDTOTest {

    private ConsignadoResponseDTO consignadoResponseDTO;

    @BeforeEach
    public void setup() {
        consignadoResponseDTO = new ConsignadoResponseDTO();
    }

    @Test
    public void testSetDataContrato() {
        LocalDate date = LocalDate.now();
        consignadoResponseDTO.setDataContrato(date);
        assertEquals(date, consignadoResponseDTO.getDataContrato());
    }

    @Test
    public void testSetCpfCliente() {
        String cpf = "12345678901";
        consignadoResponseDTO.setCpfCliente(cpf);
        assertEquals(cpf, consignadoResponseDTO.getCpfCliente());
    }

    @Test
    public void testSetConvenioCliente() {
        String convenio = "Convenio Test";
        consignadoResponseDTO.setConvenioCliente(convenio);
        assertEquals(convenio, consignadoResponseDTO.getConvenioCliente());
    }

    @Test
    public void testSetValorSolicitado() {
        BigDecimal valor = new BigDecimal("1000.00");
        consignadoResponseDTO.setValorSolicitado(valor);
        assertEquals(valor, consignadoResponseDTO.getValorSolicitado());
    }

    @Test
    public void testSetTaxaAplicada() {
        BigDecimal taxa = new BigDecimal("0.05");
        consignadoResponseDTO.setTaxaAplicada(taxa);
        assertEquals(taxa, consignadoResponseDTO.getTaxaAplicada());
    }

    @Test
    public void testSetQuantidadeParcelas() {
        int parcelas = 12;
        consignadoResponseDTO.setQuantidadeParcelas(parcelas);
        assertEquals(parcelas, consignadoResponseDTO.getQuantidadeParcelas());
    }

    @Test
    public void testSetValorTotal() {
        BigDecimal valorTotal = new BigDecimal("1200.00");
        consignadoResponseDTO.setValorTotal(valorTotal);
        assertEquals(valorTotal, consignadoResponseDTO.getValorTotal());
    }

    @Test
    public void testSetValorParcela() {
        BigDecimal valorParcela = new BigDecimal("100.00");
        consignadoResponseDTO.setValorParcela(valorParcela);
        assertEquals(valorParcela, consignadoResponseDTO.getValorParcela());
    }
}