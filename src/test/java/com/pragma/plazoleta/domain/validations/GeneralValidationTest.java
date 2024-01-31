package com.pragma.plazoleta.domain.validations;

import com.pragma.plazoleta.domain.exception.FieldNullOrEmptyException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class GeneralValidationTest {
    @ParameterizedTest
    @ValueSource(strings = {""})
    @NullSource
    void validateFieldIsNullOrEmpty_isNullOrEmpty(String field) {
        assertThrows(FieldNullOrEmptyException.class,()->GeneralValidation.validateFieldIsNullOrEmpty(field,"name"));
    }

    @Test
    void validateFieldIsNullOrEmpty_valid() {
        String data="some data";
        assertDoesNotThrow(()->GeneralValidation.validateFieldIsNullOrEmpty(data,"data"));
    }

}