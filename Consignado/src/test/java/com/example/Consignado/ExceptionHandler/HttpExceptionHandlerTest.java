package com.example.consignado.exceptionhandler;


import com.example.consignado.service.Exception.DatabaseException;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HttpExceptionHandlerTest {

    @Test
    public void testEntityNotFound() {
        // Criação de um mock HttpServletRequest
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRequestURI()).thenReturn("/test");

        // Criação do objeto HttpExceptionHandler
        HttpExceptionHandler handler = new HttpExceptionHandler();

        // Criação de uma exceção ResourceNotFoundException
        DatabaseException.ResourceNotFoundException exception = new DatabaseException.ResourceNotFoundException("Resource not found");

        // Chamada do método de tratamento de exceção
        ResponseEntity<StandardError> response = handler.entityNotFound(exception, request);

        // Verificação se a resposta possui os valores esperados
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Resouce not found ", response.getBody().getError());
        assertEquals("Resource not found", response.getBody().getMessage());
        assertEquals("/test", response.getBody().getPath());
    }

    @Test
    public void testEntityConflict() {
        // Criação de um mock HttpServletRequest
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRequestURI()).thenReturn("/test");

        // Criação do objeto HttpExceptionHandler
        HttpExceptionHandler handler = new HttpExceptionHandler();

        // Criação de uma exceção DatabaseException
        DatabaseException exception = new DatabaseException("Seguro já cadastrado");

        // Chamada do método de tratamento de exceção
        ResponseEntity<StandardError> response = handler.entityConflict(exception, request);

        // Verificação se a resposta possui os valores esperados
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals("Seguro já cadastrado", response.getBody().getError());
        assertEquals("Seguro já cadastrado", response.getBody().getMessage());
        assertEquals("/test", response.getBody().getPath());
    }
}
