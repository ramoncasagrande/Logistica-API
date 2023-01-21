package com.ramon.logisticaapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClienteIdInput {

    @NotNull
    private Long id;

    
}

