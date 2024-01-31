package com.pragma.plazoleta.domain.validations;

import com.pragma.plazoleta.domain.exception.FieldNullOrEmptyException;

public class GeneralValidation {
    private GeneralValidation() {
        throw new IllegalStateException("Utility class");
    }

    public static void validateFieldIsNullOrEmpty(Object value,String fieldName) {
        if (value == null || (value instanceof String string&& string.isEmpty())) {
            throw new FieldNullOrEmptyException(fieldName);
        }
    }
}
