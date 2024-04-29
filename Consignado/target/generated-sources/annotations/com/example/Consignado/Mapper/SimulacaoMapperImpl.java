package com.example.consignado.mapper;

import com.example.consignado.model.SimulacaoModel;
import com.example.consignado.model.dto.response.SimulacaoResponseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-30T00:42:46-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class SimulacaoMapperImpl implements SimulacaoMapper {

    @Override
    public SimulacaoResponseDTO modelToResponse(SimulacaoModel clienteModel) {
        if ( clienteModel == null ) {
            return null;
        }

        SimulacaoResponseDTO simulacaoResponseDTO = new SimulacaoResponseDTO();

        simulacaoResponseDTO.setId( clienteModel.getId() );
        simulacaoResponseDTO.setDataSimulacao( clienteModel.getDataSimulacao() );
        simulacaoResponseDTO.setCpf( clienteModel.getCpf() );
        simulacaoResponseDTO.setConvenioCliente( clienteModel.getConvenioCliente() );
        simulacaoResponseDTO.setValorSolicitado( clienteModel.getValorSolicitado() );
        simulacaoResponseDTO.setTaxaAplicada( clienteModel.getTaxaAplicada() );
        simulacaoResponseDTO.setQuantidadeParcelas( clienteModel.getQuantidadeParcelas() );
        simulacaoResponseDTO.setValorTotal( clienteModel.getValorTotal() );
        simulacaoResponseDTO.setValorParcela( clienteModel.getValorParcela() );

        return simulacaoResponseDTO;
    }

    @Override
    public List<SimulacaoResponseDTO> modelsToResponse(List<SimulacaoModel> list) {
        if ( list == null ) {
            return null;
        }

        List<SimulacaoResponseDTO> list1 = new ArrayList<SimulacaoResponseDTO>( list.size() );
        for ( SimulacaoModel simulacaoModel : list ) {
            list1.add( modelToResponse( simulacaoModel ) );
        }

        return list1;
    }
}
