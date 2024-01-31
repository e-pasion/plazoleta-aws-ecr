package com.pragma.plazoleta.application.handler.impl;

import com.pragma.plazoleta.application.dto.RestaurantDto;
import com.pragma.plazoleta.application.dto.RestaurantUpdateDto;
import com.pragma.plazoleta.application.handler.IRestaurantHandler;
import com.pragma.plazoleta.application.mapper.IRestaurantDtoMapper;
import com.pragma.plazoleta.application.mapper.IRestaurantUpdateDtoMapper;
import com.pragma.plazoleta.domain.api.IRestaurantServicePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantHandler implements IRestaurantHandler {

    private final IRestaurantDtoMapper restaurantDtoMapper;
    private final IRestaurantUpdateDtoMapper restaurantUpdateDto;
    private final IRestaurantServicePort restaurantServicePort;

    @Override
    public RestaurantDto getRestaurantById(Long id) {
        return restaurantDtoMapper.toRestaurantDto(restaurantServicePort.getRestaurantById(id));
    }

    @Override
    public List<RestaurantDto> getAllRestaurant(int cant) {
        return restaurantDtoMapper.toRestaurantsDto(restaurantServicePort.getAllRestaurant(cant).getContent());
    }

    @Override
    public void saveRestaurant(RestaurantDto restaurant) {
        restaurantServicePort.saveRestaurant(restaurantDtoMapper.toRestaurantModel(restaurant));
    }

    @Override
    public void updateRestaurant(RestaurantUpdateDto restaurant) {
        restaurantServicePort.updateRestaurant(restaurantUpdateDto.toRestaurantModel(restaurant));
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantServicePort.deleteRestaurant(id);
    }
}
