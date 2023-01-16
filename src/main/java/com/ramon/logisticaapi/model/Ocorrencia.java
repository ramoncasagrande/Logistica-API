package com.ramon.logisticaapi.model;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class Ocorrencia {

    private Long id;
    private Entrega entrega;
    private String descricao;
    private OffsetDateTime dataRegistro;
    
}
