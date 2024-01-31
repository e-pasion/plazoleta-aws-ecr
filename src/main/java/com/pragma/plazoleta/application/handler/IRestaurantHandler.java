package com.pragma.plazoleta.application.handler;

import com.pragma.plazoleta.application.dto.RestaurantDto;
import com.pragma.plazoleta.application.dto.RestaurantUpdateDto;

import java.util.List;

public interface IRestaurantHandler {
    RestaurantDto getRestaurantById(Long id);
    List<RestaurantDto> getAllRestaurant(int cant);
    void saveRestaurant(RestaurantDto restaurant);
    void updateRestaurant(RestaurantUpdateDto restaurant);
    void deleteRestaurant(Long id);
}
