package com.pragma.plazoleta.domain.spi;

import com.pragma.plazoleta.domain.model.RestaurantModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IRestaurantPersistencePort {
    RestaurantModel getRestaurantById(Long id);
    Page<RestaurantModel> getAllRestaurant(Pageable pageable);
    void saveRestaurant(RestaurantModel restaurant);
    void updateRestaurant(RestaurantModel restaurant);
    void deleteRestaurant(Long id);
}
