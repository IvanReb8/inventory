package com.liverpool.mx.inventory.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundResourceException.class)
    private ResponseEntity<ErrorResponse>HandleNotFoundResourceException(NotFoundResourceException exception, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse(
            request.getDescription(false), 
            exception.getMessage(), 
            HttpStatus.NOT_FOUND.value(), 
            LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
