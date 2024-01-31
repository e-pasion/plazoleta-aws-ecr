package com.pragma.plazoleta.domain.exception;

public class FieldNullOrEmptyException extends RuntimeException {
    public FieldNullOrEmptyException(String fieldName){
        super("The field '" + fieldName + "' cannot be empty or null.");
    }

}
