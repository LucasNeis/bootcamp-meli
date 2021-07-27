package com.meli.exercise1.exceptions;

public class ImpossibleToAccessException extends RuntimeException {
    public ImpossibleToAccessException(String message) {
        super("Impossible to access request. Reason: " + message);
    }
}
