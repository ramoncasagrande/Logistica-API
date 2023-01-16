package com.ramon.logisticaapi.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Entrega {
    
    private Long id;
    private Cliente cliente;
    private Destinatario destinatario;
    private List<Ocorrencia> ocorrencias = new ArrayList<>();
    private StatusEntrega status;
    private BigDecimal taxa;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;
}
