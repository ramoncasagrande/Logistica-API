package com.ramon.logisticaapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramon.logisticaapi.model.Entrega;
import com.ramon.logisticaapi.model.Ocorrencia;

import jakarta.transaction.Transactional;

@Service
public class OcorrenciaService {

    @Autowired
    private BuscaEntregaService buscaEntregaService;
    
    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao){
        Entrega entrega = buscaEntregaService.buscar(entregaId);
        return entrega.adicionarOcorrencia(descricao);
    }
}
