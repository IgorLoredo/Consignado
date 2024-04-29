package com.example.consignado.mapper;

import com.example.consignado.model.ConsignadoModel;
import com.example.consignado.model.SimulacaoModel;
import com.example.consignado.model.dto.response.ConsignadoResponseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-30T00:42:46-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class ConsignadoMapperImpl implements ConsignadoMapper {

    @Override
    public ConsignadoModel simulacaoToConsignado(SimulacaoModel simulacao) {
        if ( simulacao == null ) {
            return null;
        }

        ConsignadoModel consignadoModel = new ConsignadoModel();

        consignadoModel.setDataContrato( simulacao.getDataSimulacao() );
        consignadoModel.setCpfCliente( simulacao.getCpf() );
        consignadoModel.setIdSimulacao( simulacao.getId() );
        consignadoModel.setConvenioCliente( simulacao.getConvenioCliente() );
        consignadoModel.setValorSolicitado( simulacao.getValorSolicitado() );
        consignadoModel.setTaxaAplicada( simulacao.getTaxaAplicada() );
        consignadoModel.setQuantidadeParcelas( simulacao.getQuantidadeParcelas() );
        consignadoModel.setValorTotal( simulacao.getValorTotal() );
        consignadoModel.setValorParcela( simulacao.getValorParcela() );

        return consignadoModel;
    }

    @Override
    public ConsignadoResponseDTO modelToResponse(ConsignadoModel consignadoModel) {
        if ( consignadoModel == null ) {
            return null;
        }

        ConsignadoResponseDTO consignadoResponseDTO = new ConsignadoResponseDTO();

        consignadoResponseDTO.setDataContrato( consignadoModel.getDataContrato() );
        consignadoResponseDTO.setCpfCliente( consignadoModel.getCpfCliente() );
        consignadoResponseDTO.setConvenioCliente( consignadoModel.getConvenioCliente() );
        consignadoResponseDTO.setValorSolicitado( consignadoModel.getValorSolicitado() );
        consignadoResponseDTO.setTaxaAplicada( consignadoModel.getTaxaAplicada() );
        consignadoResponseDTO.setQuantidadeParcelas( consignadoModel.getQuantidadeParcelas() );
        consignadoResponseDTO.setValorTotal( consignadoModel.getValorTotal() );
        consignadoResponseDTO.setValorParcela( consignadoModel.getValorParcela() );
        consignadoResponseDTO.setIdSimulacao( consignadoModel.getIdSimulacao() );

        return consignadoResponseDTO;
    }

    @Override
    public List<ConsignadoResponseDTO> modelsToResponse(List<ConsignadoModel> list) {
        if ( list == null ) {
            return null;
        }

        List<ConsignadoResponseDTO> list1 = new ArrayList<ConsignadoResponseDTO>( list.size() );
        for ( ConsignadoModel consignadoModel : list ) {
            list1.add( modelToResponse( consignadoModel ) );
        }

        return list1;
    }
}
