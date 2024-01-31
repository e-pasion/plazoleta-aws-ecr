package com.pragma.plazoleta.domain.model;

import com.pragma.plazoleta.domain.validations.GeneralValidation;
import com.pragma.plazoleta.domain.validations.RestaurantValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantModel {
    private Long id;
    private String name;
    private String nit;
    private String address;
    private String numberPhone;
    private String urlLogo;

    public void setName(String name) {
        GeneralValidation.validateFieldIsNullOrEmpty(name,"name");
        RestaurantValidation.validateRestaurantName(name);
        this.name = name;
    }

    public void setNit(String nit) {
        GeneralValidation.validateFieldIsNullOrEmpty(nit,"nit");
        RestaurantValidation.validateRestaurantNit(nit);
        this.nit = nit;
    }

    public void setAddress(String address) {
        GeneralValidation.validateFieldIsNullOrEmpty(address,"address");
        this.address = address;
    }

    public void setNumberPhone(String numberPhone) {
        GeneralValidation.validateFieldIsNullOrEmpty(numberPhone,"number phone");
        RestaurantValidation.validateRestaurantNumberPhone(numberPhone);
        this.numberPhone = numberPhone;
    }

    public void setUrlLogo(String urlLogo) {
        GeneralValidation.validateFieldIsNullOrEmpty(urlLogo,"url logo");
        this.urlLogo = urlLogo;
    }

}
