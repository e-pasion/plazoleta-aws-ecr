package com.pragma.plazoleta.infrastructure.exceptionhandler;

import com.pragma.plazoleta.domain.exception.NitInvalidException;
import com.pragma.plazoleta.domain.exception.NumberPhoneInvalidException;
import com.pragma.plazoleta.domain.exception.RestaurantNameInvalidException;
import com.pragma.plazoleta.infrastructure.exception.NitAlreadyExistsException;
import com.pragma.plazoleta.infrastructure.exception.RestaurantNameAlreadyExistsException;
import com.pragma.plazoleta.infrastructure.exception.RestaurantNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {
    private static final String MESSAGE="Message";

    @ExceptionHandler(NitAlreadyExistsException.class)
    public ResponseEntity<Map<String,String>> handleNitAlreadyExistsException(
            NitAlreadyExistsException nitAlreadyExistsException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE,ExceptionResponse.NIT_ALREADY_EXISTS.getMessage()));
    }

    @ExceptionHandler(NitInvalidException.class)
    public ResponseEntity<Map<String,String>> handleNitInvalidException(
            NitInvalidException nitInvalidException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE,ExceptionResponse.NIT_IS_INVALID.getMessage()));
    }

    @ExceptionHandler(NumberPhoneInvalidException.class)
    public ResponseEntity<Map<String,String>> handleNumberPhoneInvalidException(
            NumberPhoneInvalidException numberPhoneInvalidException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE,ExceptionResponse.NUMBER_PHONE_IS_INVALID.getMessage()));
    }

    @ExceptionHandler(RestaurantNameInvalidException.class)
    public ResponseEntity<Map<String,String>> handleRestaurantNameInvalidException(
            RestaurantNameInvalidException restaurantNameInvalidException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE,ExceptionResponse.RESTAURANT_NAME_IS_INVALID.getMessage()));
    }

    @ExceptionHandler(RestaurantNameAlreadyExistsException.class)
    public ResponseEntity<Map<String,String>> handleRestaurantAlreadyExistsException(
            RestaurantNameAlreadyExistsException restaurantNameAlreadyExistsException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE,ExceptionResponse.RESTAURANT_NAME_ALREADY_EXISTS.getMessage()));
    }

    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleRestaurantNotFoundException(
            RestaurantNotFoundException restaurantNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE,ExceptionResponse.RESTAURANT_NOT_FOUND.getMessage()));
    }
}
