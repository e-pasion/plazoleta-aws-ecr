package com.pragma.plazoleta.infrastructure.out.jpa.adapter;

import com.pragma.plazoleta.domain.model.RestaurantModel;
import com.pragma.plazoleta.domain.spi.IRestaurantPersistencePort;
import com.pragma.plazoleta.infrastructure.exception.NitAlreadyExistsException;
import com.pragma.plazoleta.infrastructure.exception.RestaurantNameAlreadyExistsException;
import com.pragma.plazoleta.infrastructure.exception.RestaurantNotFoundException;
import com.pragma.plazoleta.infrastructure.out.jpa.mapper.IRestaurantEntityMapper;
import com.pragma.plazoleta.infrastructure.out.jpa.repository.IRestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@RequiredArgsConstructor
public class RestaurantJpaAdapter implements IRestaurantPersistencePort {

    private final IRestaurantEntityMapper restaurantEntityMapper;
    private final IRestaurantRepository restaurantRepository;
    @Override
    public RestaurantModel getRestaurantById(Long id) {
        return restaurantEntityMapper.toRestaurant(restaurantRepository.findById(id).orElseThrow(RestaurantNotFoundException::new));
    }

    @Override
    public Page<RestaurantModel> getAllRestaurant(Pageable pageable) {
        return restaurantEntityMapper.toRestaurants(restaurantRepository.findAll(pageable));
    }

    @Override
    public void saveRestaurant(RestaurantModel restaurant) {
        if(restaurantRepository.existsByName(restaurant.getName())) throw new RestaurantNameAlreadyExistsException();
        if(restaurantRepository.existsByNit(restaurant.getNit())) throw new NitAlreadyExistsException();
        restaurantRepository.save(restaurantEntityMapper.toEntity(restaurant));
    }

    @Override
    public void updateRestaurant(RestaurantModel restaurant) {
        if(!restaurantRepository.existsById(restaurant.getId())) throw new RestaurantNotFoundException();
        if(restaurantRepository.existsByName(restaurant.getName())) throw new RestaurantNameAlreadyExistsException();
        if(restaurantRepository.existsByNit(restaurant.getNit())) throw new NitAlreadyExistsException();
        restaurantRepository.save(restaurantEntityMapper.toEntity(restaurant));
    }

    @Override
    public void deleteRestaurant(Long id) {
        if(!restaurantRepository.existsById(id)) throw new RestaurantNotFoundException();
        restaurantRepository.deleteById(id);
    }
}
