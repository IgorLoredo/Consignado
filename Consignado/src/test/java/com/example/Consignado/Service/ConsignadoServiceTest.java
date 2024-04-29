
package com.example.consignado.service;

import com.example.consignado.model.dto.request.ConsignadoRequestDTO;
import com.example.consignado.model.dto.request.SimulacaoRequestDTO;
import com.example.consignado.model.dto.response.ClienteResponseDTO;
import com.example.consignado.model.dto.response.ConsignadoResponseDTO;
import com.example.consignado.model.dto.response.SimulacaoResponseDTO;
import com.example.consignado.repository.ClienteRepository;
import com.example.consignado.repository.ConsignadoRepository;
import com.example.consignado.repository.SimulacaoRepository;
import com.example.consignado.model.ClienteModel;
import com.example.consignado.model.ConsignadoModel;
import com.example.consignado.model.SimulacaoModel;


import com.example.consignado.service.Exception.DatabaseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ConsignadoServiceTest {

    @InjectMocks
    private ConsignadoService consignadoService;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private SimulacaoRepository simulacaoRepository;

    @Mock
    private ConsignadoRepository consignadoRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBuscarCliente() {
        String cpf = "452.226.424-02";
        ClienteModel clienteModel = new ClienteModel();
        when(clienteRepository.findByCpf(cpf)).thenReturn(Optional.of(clienteModel));

        ClienteResponseDTO result = consignadoService.buscarCliente(cpf);

        assertNotNull(result);
        verify(clienteRepository, times(1)).findByCpf(cpf);
    }
    @Test
    public void testBuscarCliente_NotFound() {
        // Arrange
        when(clienteRepository.findByCpf("12345678900")).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(DatabaseException.ResourceNotFoundException.class, () -> {
            consignadoService.buscarCliente("12345678900");
        });
    }
    @Test
    public void testSimulacao_Success() {
        // Arrange
        SimulacaoRequestDTO requestDTO = new SimulacaoRequestDTO("12345678900", 12, new BigDecimal("1000.00"));
            ClienteModel clienteModel = new ClienteModel("12345678900", "Fulano", "S", "Uniclass", "EP");
        when(clienteRepository.findByCpf("12345678900")).thenReturn(Optional.of(clienteModel));

        // Act
        SimulacaoResponseDTO responseDTO = consignadoService.simulacao(requestDTO);

        // Assert
        Assertions.assertEquals("12345678900", responseDTO.getCpf());
        Assertions.assertEquals(12, responseDTO.getQuantidadeParcelas());
    }

    @Test
    public void testSimulacao_ClienteNotFound() {
        // Arrange
        SimulacaoRequestDTO requestDTO = new SimulacaoRequestDTO("12345678900", 12, new BigDecimal("1000.00"));
        when(clienteRepository.findByCpf("12345678900")).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(DatabaseException.ResourceNotFoundException.class, () -> {
            consignadoService.simulacao(requestDTO);
        });
    }

    @Test
    public void testConsignado() {
        ConsignadoRequestDTO requestDTO = new ConsignadoRequestDTO();
        requestDTO.setId(1L);
        SimulacaoModel simulacaoModel = new SimulacaoModel();
        when(simulacaoRepository.findById(requestDTO.getId())).thenReturn(Optional.of(simulacaoModel));

        ConsignadoResponseDTO result = consignadoService.consigando(requestDTO);

        assertNotNull(result);
        verify(simulacaoRepository, times(1)).findById(requestDTO.getId());
        verify(consignadoRepository, times(1)).save(any(ConsignadoModel.class));
    }
    @Test
    public void testSimulacao_InvalidSegmento() {
        // Arrange
        SimulacaoRequestDTO requestDTO = new SimulacaoRequestDTO("12345678900", 12, new BigDecimal("1000.00"));
        ClienteModel clienteModel = new ClienteModel("12345678900", "Fulano", "S", "Varejo3", "EP3");
        when(clienteRepository.findByCpf("12345678900")).thenReturn(Optional.of(clienteModel));

        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> {
            consignadoService.simulacao(requestDTO);
        });
    }
    @Test
    public void testListarClientes_Success() {
        // Arrange
        ClienteModel clienteModel1 = new ClienteModel("12345678900", "Fulano", "S", "Varejo", "OP");
        ClienteModel clienteModel2 = new ClienteModel("98765432100", "Ciclano", "N", "Person", "INSS");
        when(clienteRepository.findAll()).thenReturn(List.of(clienteModel1, clienteModel2));

        // Act
        List<ClienteResponseDTO> responseDTOs = consignadoService.listarClientes();

        // Assert
        Assertions.assertEquals(2, responseDTOs.size());
        Assertions.assertEquals("12345678900", responseDTOs.get(0).getCpf());
        Assertions.assertEquals("Fulano", responseDTOs.get(0).getNome());
        Assertions.assertEquals("98765432100", responseDTOs.get(1).getCpf());
        Assertions.assertEquals("Ciclano", responseDTOs.get(1).getNome());
    }
    @Test
    public void testListarSimulacoesPorCPF_ClienteNotFound() {
        // Arrange
        when(clienteRepository.findByCpf("12345678900")).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(DatabaseException.ResourceNotFoundException.class, () -> {
            consignadoService.listarSimulacoesPorCPF("12345678900");
        });
    }
    @Test
    public void testListarConsignadosPorCPF_ClienteNotFound() {
        // Arrange
        when(clienteRepository.findByCpf("12345678900")).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(DatabaseException.ResourceNotFoundException.class, () -> {
            consignadoService.listarConsignadosPorCPF("12345678900");
        });
    }

}