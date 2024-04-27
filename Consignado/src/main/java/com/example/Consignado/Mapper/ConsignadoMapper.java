package com.example.Consignado.Mapper;

import com.example.Consignado.Model.ClienteModel;
import com.example.Consignado.Model.ConsignadoModel;
import com.example.Consignado.Model.DTO.Response.ClienteResponseDTO;
import com.example.Consignado.Model.DTO.Response.ConsignadoResponseDTO;
import com.example.Consignado.Model.SimulacaoModel;
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
