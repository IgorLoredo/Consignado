package com.example.Consignado.Logger;//package com.example.Seguros.Logger;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class LoggerFormatterTest {

    @Test
    void testFormatWithCorrelationId() {
        String message = "Test message";
        String correlationId = "123456";
        Class<?> clazz = LoggerFormatterTest.class;

        String formattedMessage = LoggerFormatter.formatWithCorrelationId(message, correlationId, clazz);
        assertEquals("LoggerFormatterTest - 123456 - Test message", formattedMessage);
    }

    @Test
    void testGenerateCorrelationId() {
        String correlationId = LoggerFormatter.generateCorrelationId();
        // Verifica se o ID de correlação gerado não está vazio
        assert (!correlationId.isEmpty());
    }

 }
