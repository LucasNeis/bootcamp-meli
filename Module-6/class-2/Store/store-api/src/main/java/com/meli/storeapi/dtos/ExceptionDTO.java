package com.meli.storeapi.dtos;

public class ExceptionDTO {
    private String message;

    public ExceptionDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
