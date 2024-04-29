package com.example.consignado.repository;


import com.example.consignado.model.SimulacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SimulacaoRepository extends JpaRepository<SimulacaoModel, UUID> {
   Optional<SimulacaoModel> findById(long id);

   List<SimulacaoModel> findAllByCpf(String cpf);
}
