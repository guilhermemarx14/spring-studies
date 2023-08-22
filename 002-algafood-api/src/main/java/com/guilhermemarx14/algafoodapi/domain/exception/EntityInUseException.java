package com.guilhermemarx14.algafoodapi.domain.exception;

public class EntityInUseException extends RuntimeException {
    public EntityInUseException(String message) {
        super(message);
    }
}
