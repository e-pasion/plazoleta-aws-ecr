package com.pragma.plazoleta.application.handler.impl;

import com.pragma.plazoleta.application.dto.RestaurantDto;
import com.pragma.plazoleta.application.dto.RestaurantUpdateDto;
import com.pragma.plazoleta.application.mapper.IRestaurantDtoMapper;
import com.pragma.plazoleta.application.mapper.IRestaurantUpdateDtoMapper;
import com.pragma.plazoleta.domain.api.IRestaurantServicePort;
import com.pragma.plazoleta.domain.model.RestaurantModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RestaurantHandlerTest {
    @Mock
    private IRestaurantServicePort restaurantServicePort;
    @Mock
    private IRestaurantDtoMapper restaurantDtoMapper;
    @Mock
    private IRestaurantUpdateDtoMapper restaurantUpdateDtoMapper;
    @InjectMocks
    private RestaurantHandler restaurantHandler;

    static RestaurantModel restaurantModel;
    static RestaurantDto restaurantDto;
    static RestaurantUpdateDto restaurantUpdateDto;
    Pageable pageable;
    @BeforeAll
    static void setUp() {
        restaurantModel=new RestaurantModel();
        restaurantModel.setId(1L);
        restaurantModel.setNumberPhone("3003735155");
        restaurantModel.setAddress("cra 54");
        restaurantModel.setName("People Pizza");
        restaurantModel.setNit("12345677");
        restaurantModel.setUrlLogo("http://localhost:8080/images/1");

        restaurantDto =new RestaurantDto();
        restaurantDto.setNumberPhone("3003735155");
        restaurantDto.setAddress("cra 54");
        restaurantDto.setName("People Pizza");
        restaurantDto.setNit("12345677");
        restaurantDto.setUrlLogo("http://localhost:8080/images/1");

        restaurantUpdateDto =new RestaurantUpdateDto();
        restaurantUpdateDto.setId(1L);
        restaurantUpdateDto.setNumberPhone("3003735155");
        restaurantUpdateDto.setAddress("cra 54");
        restaurantUpdateDto.setName("People Pizza");
        restaurantUpdateDto.setNit("12345677");
        restaurantUpdateDto.setUrlLogo("http://localhost:8080/images/1");
    }

    @Test
    void getRestaurantById() {
        when(restaurantDtoMapper.toRestaurantDto(restaurantModel)).thenReturn(restaurantDto);
        when(restaurantServicePort.getRestaurantById(1L)).thenReturn(restaurantModel);
        restaurantHandler.getRestaurantById(1L);
        verify(restaurantDtoMapper,times(1)).toRestaurantDto(restaurantModel);
        verify(restaurantServicePort,times(1)).getRestaurantById(1L);

    }

    @Test
    void getAllRestaurant() {
        int cant=1;
        pageable= PageRequest.of(0,cant, Sort.by("name").ascending());
        Page<RestaurantModel> restaurantPage= new PageImpl<>(Collections.singletonList(restaurantModel));
        when(restaurantServicePort.getAllRestaurant(cant)).thenReturn(restaurantPage);
        when(restaurantDtoMapper.toRestaurantsDto(List.of(restaurantModel))).thenReturn(List.of(restaurantDto));
        restaurantHandler.getAllRestaurant(cant);

        verify(restaurantServicePort,times(1)).getAllRestaurant(cant);
        verify(restaurantDtoMapper,times(1)).toRestaurantsDto(List.of(restaurantModel));
    }

    @Test
    void saveRestaurant() {
        when(restaurantDtoMapper.toRestaurantModel(restaurantDto)).thenReturn(restaurantModel);
        doNothing().when(restaurantServicePort).saveRestaurant(restaurantModel);
        restaurantHandler.saveRestaurant(restaurantDto);
        verify(restaurantDtoMapper,times(1)).toRestaurantModel(restaurantDto);
        verify(restaurantServicePort,times(1)).saveRestaurant(restaurantModel);
    }

    @Test
    void updateRestaurant() {
        when(restaurantUpdateDtoMapper.toRestaurantModel(restaurantUpdateDto)).thenReturn(restaurantModel);
        doNothing().when(restaurantServicePort).updateRestaurant(restaurantModel);
        restaurantHandler.updateRestaurant(restaurantUpdateDto);
        verify(restaurantUpdateDtoMapper,times(1)).toRestaurantModel(restaurantUpdateDto);
        verify(restaurantServicePort,times(1)).updateRestaurant(restaurantModel);
    }

    @Test
    void deleteRestaurant() {
        doNothing().when(restaurantServicePort).deleteRestaurant(1L);
        restaurantHandler.deleteRestaurant(1L);
        verify(restaurantServicePort,times(1)).deleteRestaurant(1L);
    }
}