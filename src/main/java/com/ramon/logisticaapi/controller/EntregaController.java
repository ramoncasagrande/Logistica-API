package com.ramon.logisticaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ramon.logisticaapi.converter.EntregaConverter;
import com.ramon.logisticaapi.dto.EntregaDto;
import com.ramon.logisticaapi.dto.EntregaInputDto;
import com.ramon.logisticaapi.model.Entrega;
import com.ramon.logisticaapi.repository.EntregaRepository;
import com.ramon.logisticaapi.services.SolicitacaoEntregaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private SolicitacaoEntregaService solicitacaoEnrtegaService;
    @Autowired
    private EntregaRepository entregaRepository;
    @Autowired
    private EntregaConverter entregaConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaDto solicitar(@Valid @RequestBody EntregaInputDto entregaInput) {
        Entrega novaEntrega = entregaConverter.converteParaEntrega(entregaInput);
        Entrega entregaSolicitada = solicitacaoEnrtegaService.solicitar(novaEntrega);
        
        return entregaConverter.converte(entregaSolicitada);
    }

    @GetMapping
    public List<EntregaDto> listar() {
        return entregaConverter.converteLista(entregaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaDto> buscar(@PathVariable Long id) {
        return entregaRepository.findById(id)
                .map(entrega -> ResponseEntity.ok(entregaConverter.converte(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }

}
