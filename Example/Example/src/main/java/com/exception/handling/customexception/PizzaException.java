package com.exception.handling.customexception;

public class PizzaException extends RuntimeException {

    public PizzaException(String message) {
        super(message);
    }
}
