package com.example.Consignado.Model.DTO.Request;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClienteRequestDTOTest {

    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidCpfFormat() {
        ClienteRequestDTO dto = new ClienteRequestDTO();
        dto.setCpf("123.456.789-09");
        assertTrue(validator.validate(dto).isEmpty());
    }

    @Test
    public void testInvalidCpfFormat() {
        ClienteRequestDTO dto1 = new ClienteRequestDTO();
        dto1.setCpf("123.456.789");
        assertEquals(2, validator.validate(dto1).size());
    }

    @Test
    public void testNullCpf() {
        ClienteRequestDTO dto3 = new ClienteRequestDTO();
        assertEquals(2, validator.validate(dto3).size());
    }

    @Test
    public void testEmptyCpf() {
        ClienteRequestDTO dto2 = new ClienteRequestDTO();
        dto2.setCpf("");
        assertEquals(3, validator.validate(dto2).size());
    }
}
