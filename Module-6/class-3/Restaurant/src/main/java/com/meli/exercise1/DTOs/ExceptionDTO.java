package com.meli.exercise1.DTOs;

public class ExceptionDTO {
    private String message;

    public ExceptionDTO() {
    }

    public ExceptionDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
