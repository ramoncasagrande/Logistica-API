package com.ramon.logisticaapi.dto;

import lombok.Data;

@Data
public class DestinatarioDto {
    
    private String nome;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
}

