package com.ramon.logisticaapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ramon.logisticaapi.model.Entrega;
import com.ramon.logisticaapi.repository.EntregaRepository;

import lombok.Data;

@Data
@Service
public class FinalizarEntregaService {

    @Autowired
    private BuscaEntregaService buscaEntregaService;

    @Autowired
    private EntregaRepository entregaRepository;

    @Transactional
    public void finalizar(Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        entrega.finalizar();
        entregaRepository.save(entrega);
    }
    
}
