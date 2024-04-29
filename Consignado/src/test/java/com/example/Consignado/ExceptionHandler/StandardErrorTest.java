package com.example.consignado.exceptionhandler;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StandardErrorTest {

    @Test
    public void testStandardError() {
        // Criação de um objeto StandardError
        StandardError error = new StandardError();

        // Definição dos valores para os atributos
        Instant timestamp = Instant.now();
        Integer status = 404;
        String errorType = "Not Found";
        String errorMessage = "Resource not found";
        String path = "/api/resource";

        // Configuração dos valores do erro
        error.setTimestamp(timestamp);
        error.setStatus(status);
        error.setError(errorType);
        error.setMessage(errorMessage);
        error.setPath(path);

        // Verifica se os valores foram configurados corretamente
        assertEquals(timestamp, error.getTimestamp());
        assertEquals(status, error.getStatus());
        assertEquals(errorType, error.getError());
        assertEquals(errorMessage, error.getMessage());
        assertEquals(path, error.getPath());

        // Verifica se os métodos de acesso e modificação não retornam null
        assertNotNull(error.getTimestamp());
        assertNotNull(error.getStatus());
        assertNotNull(error.getError());
        assertNotNull(error.getMessage());
        assertNotNull(error.getPath());
    }
}
