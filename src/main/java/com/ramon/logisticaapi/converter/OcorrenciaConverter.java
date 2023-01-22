package com.ramon.logisticaapi.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ramon.logisticaapi.dto.OcorrenciaDto;
import com.ramon.logisticaapi.model.Ocorrencia;

import lombok.Data;

@Data
@Component
public class OcorrenciaConverter {
    
    @Autowired
    private ModelMapper modelMapper;

    public OcorrenciaDto converteParaOcorrenciaDto(Ocorrencia ocorrencia){
        return modelMapper.map(ocorrencia, OcorrenciaDto.class);
    }
}
