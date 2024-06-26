package com.example.consignado.mapper;

import com.example.consignado.model.ConsignadoModel;
import com.example.consignado.model.dto.response.ConsignadoResponseDTO;
import com.example.consignado.model.SimulacaoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ConsignadoMapper {

    ConsignadoMapper INSTANCE = Mappers.getMapper(ConsignadoMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataContrato", source = "dataSimulacao")
    @Mapping(target = "cpfCliente", source = "cpf")
    @Mapping(target = "idSimulacao", source = "id")
    ConsignadoModel simulacaoToConsignado(SimulacaoModel simulacao);

    @Mapping(source = "dataContrato", target = "dataContrato")
    @Mapping(source = "cpfCliente", target = "cpfCliente")
    @Mapping(source = "convenioCliente", target = "convenioCliente")
    @Mapping(source = "valorSolicitado", target = "valorSolicitado")
    @Mapping(source = "taxaAplicada", target = "taxaAplicada")
    @Mapping(source = "quantidadeParcelas", target = "quantidadeParcelas")
    @Mapping(source = "valorTotal", target = "valorTotal")
    @Mapping(source = "valorParcela", target = "valorParcela")
    ConsignadoResponseDTO modelToResponse(ConsignadoModel consignadoModel);

    @Mapping(source = "dataContrato", target = "dataContrato")
    @Mapping(source = "cpfCliente", target = "cpfCliente")
    @Mapping(source = "convenioCliente", target = "convenioCliente")
    @Mapping(source = "valorSolicitado", target = "valorSolicitado")
    @Mapping(source = "taxaAplicada", target = "taxaAplicada")
    @Mapping(source = "quantidadeParcelas", target = "quantidadeParcelas")
    @Mapping(source = "valorTotal", target = "valorTotal")
    @Mapping(source = "valorParcela", target = "valorParcela")
    List<ConsignadoResponseDTO> modelsToResponse(List<ConsignadoModel> list);
}
