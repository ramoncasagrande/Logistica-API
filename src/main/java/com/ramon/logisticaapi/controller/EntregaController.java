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

import com.ramon.logisticaapi.dto.DestinatarioDto;
import com.ramon.logisticaapi.dto.EntregaDto;
import com.ramon.logisticaapi.model.Destinatario;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@Valid @RequestBody Entrega entrega) {
        return solicitacaoEnrtegaService.solicitar(entrega);
    }

    @GetMapping
    public List<Entrega> listar() {
        return entregaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaDto> buscar(@PathVariable Long id) {
        return entregaRepository.findById(id)
                .map(entrega -> {
                    EntregaDto entregaDto = new EntregaDto();
                    entregaDto.setId(entrega.getId());
                    entregaDto.setNomeCliente(entrega.getCliente().getNome());
                    entregaDto.setDestinatario(new DestinatarioDto());
                    entregaDto.getDestinatario().setNome(entrega.getDestinatario().getNome());
                    entregaDto.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
                    entregaDto.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
                    entregaDto.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
                    entregaDto.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
                    entregaDto.setTaxa(entrega.getTaxa());
                    entregaDto.setStatus(entrega.getStatus());
                    entregaDto.setDataPedido(entrega.getDataPedido());
                    entregaDto.setDataFinalizacao(entrega.getDataFinalizacao());

                    return ResponseEntity.ok(entregaDto);
                }).orElse(ResponseEntity.notFound().build());
    }

}
