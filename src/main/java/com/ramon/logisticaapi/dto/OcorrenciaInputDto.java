package com.ramon.logisticaapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OcorrenciaInputDto {
    
    @NotBlank
    private String descricao;
}
