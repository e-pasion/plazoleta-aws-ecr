package com.pragma.plazoleta.domain.validations;

import com.pragma.plazoleta.domain.exception.NitInvalidException;
import com.pragma.plazoleta.domain.exception.NumberPhoneInvalidException;
import com.pragma.plazoleta.domain.exception.RestaurantNameInvalidException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantValidationTest {
    @ParameterizedTest
    @ValueSource(strings = {"+574003735155","5660600","3014445155"})
    void testValidateRestaurantNumberPhone_ValidNumberPhone(String numberPhone) {
        assertDoesNotThrow(()->RestaurantValidation.validateRestaurantNumberPhone(numberPhone));
    }
    @ParameterizedTest
    @ValueSource(strings = {"+5740037351551","2770600a","3003735155+57"})
    void testValidateRestaurantNumberPhone_InvalidNumberPhone(String numberPhone) {
        assertThrows(NumberPhoneInvalidException.class,()->RestaurantValidation.validateRestaurantNumberPhone(numberPhone));
    }

    @Test
    void validateRestaurantNit_validNit() {
        String nit="1231241241";
        assertDoesNotThrow(()->RestaurantValidation.validateRestaurantNit(nit));
    }
    @Test
    void validateRestaurantNit_InvalidNit() {
        String nit="a1231241241a";
        assertThrows(NitInvalidException.class,()->RestaurantValidation.validateRestaurantNit(nit));
    }

    @ParameterizedTest
    @ValueSource(strings = {"arkadia","el venado","enkonados23"})
    void validateRestaurantName_ValidName(String name) {
        assertDoesNotThrow(()->RestaurantValidation.validateRestaurantName(name));
    }

    @Test
    void validateRestaurantName_InvalidName() {
        String name="12312312";
        assertThrows(RestaurantNameInvalidException.class,()->RestaurantValidation.validateRestaurantName(name));
    }

}