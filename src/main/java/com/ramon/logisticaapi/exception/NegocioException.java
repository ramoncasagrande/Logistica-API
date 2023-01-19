package com.ramon.logisticaapi.exception;

public class NegocioException extends RuntimeException {

    private static final long SerialVersionUID = 1L;

    public NegocioException(String mensagem){
        super(mensagem);
    }
    
}
