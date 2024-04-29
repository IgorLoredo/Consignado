package com.example.consignado.util;

import org.junit.jupiter.api.Test;

class LoggerFormatterTest {

    @Test
    void testGenerateCorrelationId() {
        String correlationId = LoggerFormatter.generateCorrelationId();
        // Verifica se o ID de correlação gerado não está vazio
        assert (!correlationId.isEmpty());
    }

 }
