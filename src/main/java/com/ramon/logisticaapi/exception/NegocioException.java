package com.ramon.logisticaapi.exception;

public class NegocioException extends RuntimeException {

    public NegocioException(String mensagem){
        super(mensagem);
    }
    
}
