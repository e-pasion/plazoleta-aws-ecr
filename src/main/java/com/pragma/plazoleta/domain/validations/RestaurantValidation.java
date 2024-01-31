package com.pragma.plazoleta.domain.validations;

import com.pragma.plazoleta.domain.exception.NitInvalidException;
import com.pragma.plazoleta.domain.exception.NumberPhoneInvalidException;
import com.pragma.plazoleta.domain.exception.RestaurantNameInvalidException;

import java.util.regex.Pattern;

public class RestaurantValidation {

    private RestaurantValidation() {
        throw new IllegalStateException("Utility class");
    }

    public static void validateRestaurantNumberPhone(String numberPhone){
        Pattern numberPhonePattern = Pattern.compile("^\\+?+\\d+$");
        if (!numberPhonePattern.matcher(numberPhone).matches()||numberPhone.length()>13) throw new NumberPhoneInvalidException();
    }
    public static void validateRestaurantNit(String nit){
        Pattern identityNumberPattern = Pattern.compile("^\\d+$");
        if (!identityNumberPattern.matcher(nit).matches()) throw new NitInvalidException();
    }
    public static void validateRestaurantName(String name){
        Pattern identityNumberPattern = Pattern.compile("^(?=.*[a-zA-Z])[a-zA-Z0-9\\s]+$");
        if (!identityNumberPattern.matcher(name).matches()) throw new RestaurantNameInvalidException();
    }
}
