package com.ramon.logisticaapi.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ramon.logisticaapi.model.Cliente;
import com.ramon.logisticaapi.model.Entrega;
import com.ramon.logisticaapi.model.StatusEntrega;
import com.ramon.logisticaapi.repository.EntregaRepository;

@Service
public class SolicitacaoEntregaService {

    @Autowired
    private EntregaRepository entregaRepository;
    @Autowired
    private ClienteService clienteService;


    @Transactional
    public Entrega solicitar(Entrega entrega){
        Cliente cliente = clienteService.verificaCliente(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());
        return entregaRepository.save(entrega);

    }

    
}
