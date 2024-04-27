package com.example.Consignado.Repository;

import com.example.Consignado.Model.ConsignadoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ConsignadoRepository extends JpaRepository<ConsignadoModel, UUID> {
    ConsignadoModel findByIdAndCpfCliente(Long id, String cpfCliente);

    List<ConsignadoModel> findByCpfCliente(String cpfCliente);
}
