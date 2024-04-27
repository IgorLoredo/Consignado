package com.example.Consignado.Repository;


import com.example.Consignado.Model.SimulacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SimulacaoRepository extends JpaRepository<SimulacaoModel, UUID> {
    Optional<SimulacaoModel> findByCpf(String cpf);
    Optional<SimulacaoModel> findById(long id);

   List<SimulacaoModel> findAllByCpf(String cpf);
}
