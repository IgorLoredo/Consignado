package com.example.Consignado.Mapper;

import com.example.Consignado.Model.DTO.Response.SimulacaoResponseDTO;
import com.example.Consignado.Model.SimulacaoModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SimulacaoMapper {
    SimulacaoMapper INSTANCE = Mappers.getMapper(SimulacaoMapper.class);

    SimulacaoResponseDTO modelToResponse(SimulacaoModel clienteModel);

    List<SimulacaoResponseDTO> modelsToResponse(List<SimulacaoModel> list);

}
