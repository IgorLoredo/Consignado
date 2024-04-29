package com.example.consignado.model.dto.request;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class SimulacaoRequestDTOTest {

    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidCpfFormat() {
        SimulacaoRequestDTO dto = new SimulacaoRequestDTO();
        dto.setCpf("123.456.789-09");
        assertFalse(validator.validate(dto).isEmpty());
    }

    @Test
    public void testInvalidCpfFormat() {
        SimulacaoRequestDTO dto = new SimulacaoRequestDTO();
        dto.setCpf("123.456.789");
        assertEquals(3, validator.validate(dto).size());
    }

    @Test
    public void testValidQuantParcelas() {
        SimulacaoRequestDTO dto = new SimulacaoRequestDTO();
        dto.setQuantParcelas(12);
        assertFalse(validator.validate(dto).isEmpty());
    }

    @Test
    public void testValidValorSolicitado() {
        SimulacaoRequestDTO dto = new SimulacaoRequestDTO();
        dto.setValorSolicitado(BigDecimal.valueOf(1000));
        assertFalse(validator.validate(dto).isEmpty());
    }

    @Test
    public void testNullValorSolicitado() {
        SimulacaoRequestDTO dto = new SimulacaoRequestDTO();
        assertEquals(3, validator.validate(dto).size());
    }
}
