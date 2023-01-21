package com.ramon.logisticaapi.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ramon.logisticaapi.dto.EntregaDto;
import com.ramon.logisticaapi.dto.EntregaInputDto;
import com.ramon.logisticaapi.model.Entrega;

@Component
public class EntregaConverter {

    @Autowired
    private ModelMapper modelMapper;

    public EntregaDto converte(Entrega entrega){
        return modelMapper.map(entrega, EntregaDto.class);
    }

    public List<EntregaDto> converteLista(List<Entrega> entregas){
       return entregas.stream()
            .map(this::converte)
            .collect(Collectors.toList());
    }

    public Entrega converteParaEntrega(EntregaInputDto entregaInput){
        return modelMapper.map(entregaInput, Entrega.class);
    }
    
}
