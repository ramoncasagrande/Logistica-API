package com.ramon.logisticaapi.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Destinatario {

    private String nome;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    
}
