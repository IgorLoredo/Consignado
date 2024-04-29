package com.example.consignado.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteModelTest {
    private ClienteModel cliente;

    @BeforeEach
    public void setUp() {
        cliente = new ClienteModel("12345678901", "Test Name", "Yes", "Test Segment", "Test Convenio");
    }

    @Test
    public void testGetId() {
        cliente.setId(1L);
        assertEquals(1L, cliente.getId());
    }

    @Test
    public void testGetCpf() {
        assertEquals("12345678901", cliente.getCpf());
    }

    @Test
    public void testSetCpf() {
        cliente.setCpf("09876543210");
        assertEquals("09876543210", cliente.getCpf());
    }

    @Test
    public void testGetNome() {
        assertEquals("Test Name", cliente.getNome());
    }

    @Test
    public void testSetNome() {
        cliente.setNome("New Test Name");
        assertEquals("New Test Name", cliente.getNome());
    }

    @Test
    public void testGetCorrentista() {
        assertEquals("Yes", cliente.getCorrentista());
    }

    @Test
    public void testSetCorrentista() {
        cliente.setCorrentista("No");
        assertEquals("No", cliente.getCorrentista());
    }

    @Test
    public void testGetSegmento() {
        assertEquals("Test Segment", cliente.getSegmento());
    }

    @Test
    public void testSetSegmento() {
        cliente.setSegmento("New Test Segment");
        assertEquals("New Test Segment", cliente.getSegmento());
    }

    @Test
    public void testGetConvenio() {
        assertEquals("Test Convenio", cliente.getConvenio());
    }

    @Test
    public void testSetConvenio() {
        cliente.setConvenio("New Test Convenio");
        assertEquals("New Test Convenio", cliente.getConvenio());
    }
}