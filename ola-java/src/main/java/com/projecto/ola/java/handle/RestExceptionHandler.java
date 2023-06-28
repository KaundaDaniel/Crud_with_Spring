package com.projecto.ola.java.handle;

import com.projecto.ola.java.model.error.ErrorMensagem;
import com.projecto.ola.java.model.exception.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<?>handlerResourceNotFoundException(ResourceNotFound ex){
        ErrorMensagem error=new ErrorMensagem("Produto não encontrado!", HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return  new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
