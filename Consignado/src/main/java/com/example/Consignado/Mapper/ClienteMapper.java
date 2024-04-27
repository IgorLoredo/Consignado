package com.example.Consignado.Mapper;

import com.example.Consignado.Controller.Enum.Convenio;
import com.example.Consignado.Controller.Enum.Segmento;
import com.example.Consignado.Model.ClienteModel;
import com.example.Consignado.Model.DTO.Response.ClienteResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Objects;

@Mapper
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mapping(source = "segmento",target = "segmento", qualifiedByName = "getSegmento")
    @Mapping(source = "convenio",target = "convenio", qualifiedByName = "getConvenio")
    ClienteResponseDTO modelToResponse(ClienteModel clienteModel);

    List<ClienteResponseDTO> modelsToResponse(List<ClienteModel> list);

    @Named("getSegmento")
    default Segmento getSegmento(String nome){
        return Objects.nonNull(nome) ? Segmento.valueOf(nome): null;
    }

    @Named("getConvenio")
    default Convenio getConvenio(String nome){
        return Objects.nonNull(nome) ? Convenio.valueOf(nome): null;
    }
}
