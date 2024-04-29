package com.example.consignado.repository;

import com.example.consignado.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<ClienteModel, UUID> {
    Optional<ClienteModel> findByCpf (String  cpf);
}
