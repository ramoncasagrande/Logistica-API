package com.ramon.logisticaapi.dto;

import java.math.BigDecimal;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EntregaInputDto {
    
    @Valid
    @NotNull
    private ClienteIdInput cliente;

    @Valid
    @NotNull
    private DestinatarioInput destinatario;

    @NotNull
    private BigDecimal taxa;
}
