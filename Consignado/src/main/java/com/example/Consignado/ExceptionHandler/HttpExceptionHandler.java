package com.example.consignado.exceptionhandler;

import com.example.consignado.service.Exception.DatabaseException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Instant;


@ControllerAdvice
public class HttpExceptionHandler {

    @ExceptionHandler(DatabaseException.ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(DatabaseException.ResourceNotFoundException e, HttpServletRequest request){

        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("Resouce not found ");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> entityConflict(DatabaseException e, HttpServletRequest request){

        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.CONFLICT.value());
        err.setError("Seguro já cadastrado");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(err);
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError>  handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setError("Campo inválido");
        err.setMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(err);
    }
}
