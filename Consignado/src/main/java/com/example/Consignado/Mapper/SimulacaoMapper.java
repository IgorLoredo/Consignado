package com.example.consignado.mapper;

import com.example.consignado.model.dto.response.SimulacaoResponseDTO;
import com.example.consignado.model.SimulacaoModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SimulacaoMapper {
    SimulacaoMapper INSTANCE = Mappers.getMapper(SimulacaoMapper.class);

    SimulacaoResponseDTO modelToResponse(SimulacaoModel clienteModel);

    List<SimulacaoResponseDTO> modelsToResponse(List<SimulacaoModel> list);

}
