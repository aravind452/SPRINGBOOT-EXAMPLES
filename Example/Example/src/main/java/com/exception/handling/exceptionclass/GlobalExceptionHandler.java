package com.exception.handling.exceptionclass;


import com.exception.handling.customexception.PizzaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PizzaException.class)
    public ResponseEntity<String> pizzaNotExistsException(PizzaException pizzaException) {
        return new ResponseEntity<>(pizzaException.getMessage(), HttpStatus.CONFLICT);
    }
}
