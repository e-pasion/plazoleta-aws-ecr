package com.pragma.plazoleta.infrastructure.exceptionhandler;

import lombok.Getter;

@Getter
public enum ExceptionResponse {
    NIT_ALREADY_EXISTS("There is already a restaurant with that NIT"),
    NIT_IS_INVALID("The NIT can only have numbers"),
    NUMBER_PHONE_IS_INVALID("The phone number is in the wrong format and cannot have more than 13 digits"),
    RESTAURANT_NAME_IS_INVALID("The name must contain at least one letter"),
    RESTAURANT_NOT_FOUND("No Restaurant was found"),
    RESTAURANT_NAME_ALREADY_EXISTS("There is already a restaurant with that name");

    private final String message;

    ExceptionResponse(String message){
        this.message=message;
    }
}
