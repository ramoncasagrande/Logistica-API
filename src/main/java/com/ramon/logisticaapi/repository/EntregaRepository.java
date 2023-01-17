package com.ramon.logisticaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramon.logisticaapi.model.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Long>{
    
}
