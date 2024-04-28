package com.example.Consignado.Controller;

import com.example.Consignado.Enum.Convenio;
import com.example.Consignado.Enum.Segmento;
import com.example.Consignado.Model.DTO.Request.ConsignadoRequestDTO;
import com.example.Consignado.Model.DTO.Request.SimulacaoRequestDTO;
import com.example.Consignado.Model.DTO.Response.ClienteResponseDTO;
import com.example.Consignado.Model.DTO.Response.ConsignadoResponseDTO;
import com.example.Consignado.Model.DTO.Response.SimulacaoResponseDTO;
import com.example.Consignado.Service.ConsignadoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class ConsignadoControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsignadoService consignadoService;

    @Test
    public void testListarClientes() throws Exception {
        List<ClienteResponseDTO> clientes = new ArrayList<>();
        clientes.add(new ClienteResponseDTO("12345678900", "Fulano", "S", Segmento.Varejo, Convenio.valueOf("EP")));
        when(consignadoService.listarClientes()).thenReturn(clientes);

        mockMvc.perform(get("/v0/consignado/clientes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].CPF").value("12345678900"))
                .andExpect(jsonPath("$[0].Nome").value("Fulano"))
                .andExpect(jsonPath("$[0].Correntista").value("S"));


    }

    @Test
    public void testListarSimulacoesPorCPF() throws Exception {
        List<SimulacaoResponseDTO> simulacoes = new ArrayList<>();
        simulacoes.add(new SimulacaoResponseDTO(1L, LocalDate.now(), "12345678900", "Convenio 1",
                new BigDecimal("1000.00"), new BigDecimal("0.05"), 12,
                new BigDecimal("1100.00"), new BigDecimal("91.67")));
        when(consignadoService.listarSimulacoesPorCPF(anyString())).thenReturn(simulacoes);

        mockMvc.perform(get("/v0/consignado/simulacoes/12345678900")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].cpf").value("12345678900"))
                .andExpect(jsonPath("$[0].convenioCliente").value("Convenio 1"));
    }
    @Test
    public void testGetCliente() throws Exception {
        ClienteResponseDTO cliente = new ClienteResponseDTO("12345678900", "Fulano", "S", Segmento.Varejo, Convenio.valueOf("EP"));
        when(consignadoService.buscarCliente(anyString())).thenReturn(cliente);

        mockMvc.perform(get("/v0/consignado/cliente/12345678900")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.CPF").value("12345678900"))
                .andExpect(jsonPath("$.Nome").value("Fulano"))
                .andExpect(jsonPath("$.Correntista").value("S"));
    }


    @Test
    public void testListarConsignadosPorCPF() throws Exception {
        List<ConsignadoResponseDTO> consignados = new ArrayList<>();
        consignados.add(new ConsignadoResponseDTO(1L, "12345678900", "Consignado 1", new BigDecimal("1000.00")));
        when(consignadoService.listarConsignadosPorCPF(anyString())).thenReturn(consignados);

        mockMvc.perform(get("/v0/consignado/consignados/12345678900")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].cpfCliente").value("12345678900"))
                .andExpect(jsonPath("$[0].convenioCliente").value("Consignado 1"));
    }
    @Test
    public void testSimulacao() throws Exception {
        SimulacaoRequestDTO requestDTO = new SimulacaoRequestDTO();
        requestDTO.setCpf("862.881.271-75");
        requestDTO.setQuantParcelas(12);
        requestDTO.setValorSolicitado(new BigDecimal("1000.00"));

        SimulacaoResponseDTO simulacaoResponseDTO = new SimulacaoResponseDTO(1L, LocalDate.now(), "862.881.271-75", "OP",
                new BigDecimal("1000.00"), new BigDecimal("0.05"), 12,
                new BigDecimal("1100.00"), new BigDecimal("91.67"));
        when(consignadoService.simulacao(requestDTO)).thenReturn(simulacaoResponseDTO);

        mockMvc.perform(post("/v0/consignado/simulacao")
                        .content("{ \"CPF\": \"862.881.271-75\", \"quantParcelas\": 12, \"valorSolicitado\": 1000.00 }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testContratacao() throws Exception {
        ConsignadoRequestDTO requestDTO = new ConsignadoRequestDTO();
        requestDTO.setCpf("862.881.271-75");
        requestDTO.setIdConsigando(1L);

        ConsignadoResponseDTO consignadoResponseDTO = new ConsignadoResponseDTO(1L, "862.881.271-75", "EP", new BigDecimal("1000.00"));
        when(consignadoService.consigando(requestDTO)).thenReturn(consignadoResponseDTO);

        mockMvc.perform(post("/v0/consignado/contratar")
                        .content("{ \"CPF\": \"862.881.271-75\", \"idConsigando\": 1 }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
