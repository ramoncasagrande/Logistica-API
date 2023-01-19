package com.ramon.logisticaapi.exception;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class Erro {

    private Integer status;
    private LocalDateTime dataHora;
    private String descrição;
    private List<Problema> problemas;

    @AllArgsConstructor
    @Getter
    public static class Problema {

        private String campo;
        private String mensagem;
    }
    
}
