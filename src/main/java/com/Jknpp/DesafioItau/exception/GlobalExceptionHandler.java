package com.Jknpp.DesafioItau.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TransacaoInvalidaException.class)
    public ResponseEntity<Void> transacaoInvalidaHandler(){
        return ResponseEntity.unprocessableEntity().build();
    }
}
