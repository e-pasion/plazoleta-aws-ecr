package com.pragma.plazoleta.domain.api;

import com.pragma.plazoleta.domain.model.RestaurantModel;
import org.springframework.data.domain.Page;


public interface IRestaurantServicePort {
    RestaurantModel getRestaurantById(Long id);
    Page<RestaurantModel> getAllRestaurant(int cant);
    void saveRestaurant(RestaurantModel restaurant);
    void updateRestaurant(RestaurantModel restaurant);
    void deleteRestaurant(Long id);
}
