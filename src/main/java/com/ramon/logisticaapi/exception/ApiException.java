package com.ramon.logisticaapi.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiException extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    @Nullable
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<Erro.Problema> problemas = new ArrayList<>();        

        for(ObjectError erros : ex.getBindingResult().getAllErrors()){
            String nome = ((FieldError) erros).getField();
            String mensagem = messageSource.getMessage(erros, LocaleContextHolder.getLocale());
            problemas.add(new Erro.Problema(nome, mensagem));
        }   
        
        Erro erro = new Erro();
        erro.setStatus(status.value());
        erro.setDataHora(LocalDateTime.now());
        erro.setDescrição("Dados inválidos.");
        erro.setProblemas(problemas);

        return handleExceptionInternal(ex, erro, headers, status, request);
    }

}
