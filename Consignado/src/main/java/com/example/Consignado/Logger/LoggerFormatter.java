package com.example.Consignado.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class LoggerFormatter {

    private static final Logger log = LoggerFactory.getLogger(LoggerFormatter.class);

    public static String formatWithCorrelationId(String message, String correlationId, Class<?> clazz) {
        return clazz.getSimpleName() + " - " + correlationId + " - "+ message;
    }

    public static String generateCorrelationId() {
        return UUID.randomUUID().toString();
    }

    public static void logInfo(String message, String correlationId, Class<?> clazz) {
        log.info(formatWithCorrelationId(message, correlationId, clazz));
    }

}
