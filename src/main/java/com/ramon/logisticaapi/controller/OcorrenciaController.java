package com.ramon.logisticaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ramon.logisticaapi.converter.OcorrenciaConverter;
import com.ramon.logisticaapi.dto.OcorrenciaDto;
import com.ramon.logisticaapi.dto.OcorrenciaInputDto;
import com.ramon.logisticaapi.model.Ocorrencia;
import com.ramon.logisticaapi.services.OcorrenciaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService ocorrenciaService;

    @Autowired
    private OcorrenciaConverter ocorrenciaConverter;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaDto registrar(@PathVariable Long entregaId, 
            @Valid @RequestBody OcorrenciaInputDto ocorrenciaInputDto){
        Ocorrencia novaOcorrencia = ocorrenciaService.registrar(entregaId, ocorrenciaInputDto.getDescricao());

        return ocorrenciaConverter.converteParaOcorrenciaDto(novaOcorrencia);
    }
}
