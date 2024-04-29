package com.example.consignado.mapper;

import com.example.consignado.model.ClienteModel;
import com.example.consignado.model.dto.response.ClienteResponseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-30T00:42:46-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteResponseDTO modelToResponse(ClienteModel clienteModel) {
        if ( clienteModel == null ) {
            return null;
        }

        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();

        clienteResponseDTO.setSegmento( getSegmento( clienteModel.getSegmento() ) );
        clienteResponseDTO.setConvenio( getConvenio( clienteModel.getConvenio() ) );
        clienteResponseDTO.setCpf( clienteModel.getCpf() );
        clienteResponseDTO.setNome( clienteModel.getNome() );
        clienteResponseDTO.setCorrentista( clienteModel.getCorrentista() );

        return clienteResponseDTO;
    }

    @Override
    public List<ClienteResponseDTO> modelsToResponse(List<ClienteModel> list) {
        if ( list == null ) {
            return null;
        }

        List<ClienteResponseDTO> list1 = new ArrayList<ClienteResponseDTO>( list.size() );
        for ( ClienteModel clienteModel : list ) {
            list1.add( modelToResponse( clienteModel ) );
        }

        return list1;
    }
}
