package com.example.consignado.mapper;

import com.example.consignado.enuns.Convenio;
import com.example.consignado.enuns.Segmento;
import com.example.consignado.model.ClienteModel;
import com.example.consignado.model.dto.response.ClienteResponseDTO;
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

    @Mapping(source = "segmento",target = "segmento", qualifiedByName = "getSegmento")
    @Mapping(source = "convenio",target = "convenio", qualifiedByName = "getConvenio")
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
