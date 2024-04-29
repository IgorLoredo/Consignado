package com.example.consignado.model.dto.response;// FILEPATH: /c:/Users/Igor Loredo/Documents/projetos Java/Consignado/src/test/java/com/example/Consignado/Model/DTO/Response/ClienteResponseDTOTest.java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteResponseDTOTest {

    @Test
    public void testGetAndSetCpf() {
        ClienteResponseDTO cliente = new ClienteResponseDTO();
        cliente.setCpf("12345678901");
        assertEquals("12345678901", cliente.getCpf());
    }

    @Test
    public void testGetAndSetNome() {
        ClienteResponseDTO cliente = new ClienteResponseDTO();
        cliente.setNome("Test Name");
        assertEquals("Test Name", cliente.getNome());
    }

    @Test
    public void testGetAndSetCorrentista() {
        ClienteResponseDTO cliente = new ClienteResponseDTO();
        cliente.setCorrentista("Test Correntista");
        assertEquals("Test Correntista", cliente.getCorrentista());
    }

}