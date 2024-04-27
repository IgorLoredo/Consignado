package com.example.Consignado.Model.DTO.Request;


import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConsignadoRequestDTOTest {

    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testSetCpf() {
        ConsignadoRequestDTO dto = new ConsignadoRequestDTO();
        String cpf = "123.456.789-09";
        dto.setCpf(cpf);
        assertEquals(cpf, dto.getCpf());
    }

    @Test
    public void testSetCpfWithInvalidFormat() {
        ConsignadoRequestDTO dto = new ConsignadoRequestDTO();
        String cpf = "12345678909";
        dto.setCpf(cpf);
        assertFalse(validator.validate(dto).isEmpty());
    }

    @Test
    public void testSetCpfWithNull() {
        ConsignadoRequestDTO dto = new ConsignadoRequestDTO();
        dto.setCpf(null);
        assertFalse(validator.validate(dto).isEmpty());
    }

    @Test
    public void testSetIdConsigando() {
        ConsignadoRequestDTO dto = new ConsignadoRequestDTO();
        long id = 12345L;
        dto.setIdConsigando(id);
        assertEquals(id, dto.getIdConsigando());
    }


}
