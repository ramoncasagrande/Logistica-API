package com.ramon.logisticaapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramon.logisticaapi.exception.NegocioException;
import com.ramon.logisticaapi.model.Entrega;
import com.ramon.logisticaapi.repository.EntregaRepository;

@Service
public class BuscaEntregaService {

    @Autowired
    private EntregaRepository entregaRepository;
    
    public Entrega buscar(Long entregaId){
        return entregaRepository.findById(entregaId)
                    .orElseThrow(() -> new NegocioException("Entrega não Encontrada"));
        
    }

}
