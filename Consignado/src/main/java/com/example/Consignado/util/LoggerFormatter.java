package com.example.consignado.util;

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

}
