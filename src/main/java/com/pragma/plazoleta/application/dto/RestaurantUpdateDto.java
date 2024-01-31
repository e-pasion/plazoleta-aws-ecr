package com.pragma.plazoleta.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantUpdateDto {
    private Long id;
    private String name;
    private String nit;
    private String address;
    private String numberPhone;
    private String urlLogo;
}
