package com.example.consignado.repository;

import com.example.consignado.model.ConsignadoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ConsignadoRepository extends JpaRepository<ConsignadoModel, UUID> {
    List<ConsignadoModel> findByCpfCliente(String cpfCliente);
}
