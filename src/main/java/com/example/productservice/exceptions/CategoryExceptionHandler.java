package com.example.productservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class CategoryExceptionHandler {
    @ExceptionHandler(value = {CategoryException.class})
    public ResponseEntity<Object> handleApiRequestException(CategoryException e){
        ExceptionBody exceptionBody = new ExceptionBody(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(exceptionBody, HttpStatus.BAD_REQUEST);
    }
}
