package com.ramon.logisticaapi.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.ramon.logisticaapi.model.StatusEntrega;

import lombok.Data;

@Data
public class EntregaDto {
    
    private Long id;
    private String nomeCliente;
    private DestinatarioDto destinatario;
    private BigDecimal taxa;
    private StatusEntrega status;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;

}
