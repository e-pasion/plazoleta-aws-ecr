package com.pragma.plazoleta.domain.usecase;

import com.pragma.plazoleta.domain.api.IRestaurantServicePort;
import com.pragma.plazoleta.domain.model.RestaurantModel;
import com.pragma.plazoleta.domain.spi.IRestaurantPersistencePort;
import com.pragma.plazoleta.domain.validations.GeneralValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
@Slf4j
public class RestaurantUseCase implements IRestaurantServicePort {

    private final IRestaurantPersistencePort restaurantPersistencePort;

    public RestaurantUseCase(IRestaurantPersistencePort restaurantPersistencePort) {
        this.restaurantPersistencePort = restaurantPersistencePort;
    }

    @Override
    public RestaurantModel getRestaurantById(Long id) {
        return restaurantPersistencePort.getRestaurantById(id);
    }

    @Override
    public Page<RestaurantModel> getAllRestaurant(int cant) {
        Pageable pageable= PageRequest.of(0,cant, Sort.by("name").ascending());
        log.info("restaurantes obtenidos");
        return restaurantPersistencePort.getAllRestaurant(pageable);
    }

    @Override
    public void saveRestaurant(RestaurantModel restaurant) {
        restaurantPersistencePort.saveRestaurant(restaurant);

    }

    @Override
    public void updateRestaurant(RestaurantModel restaurant) {
        GeneralValidation.validateFieldIsNullOrEmpty(restaurant.getId(),"ID");
        restaurantPersistencePort.updateRestaurant(restaurant);
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantPersistencePort.deleteRestaurant(id);
    }
}
