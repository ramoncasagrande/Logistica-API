package com.ramon.logisticaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramon.logisticaapi.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
