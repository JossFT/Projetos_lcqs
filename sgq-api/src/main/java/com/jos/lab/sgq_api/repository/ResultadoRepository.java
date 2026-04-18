package com.jos.lab.sgq_api.repository;

import com.jos.lab.sgq_api.model.ResultadoUfc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoRepository extends JpaRepository<ResultadoUfc, Long> {
    // Com isso, o Spring já cria os comandos 'salvar' e 'buscar' no MySQL para você!
}