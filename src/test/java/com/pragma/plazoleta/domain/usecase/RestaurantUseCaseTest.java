package com.pragma.plazoleta.domain.usecase;

import com.pragma.plazoleta.domain.model.RestaurantModel;
import com.pragma.plazoleta.domain.spi.IRestaurantPersistencePort;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class RestaurantUseCaseTest {
    @Mock
    IRestaurantPersistencePort restaurantPersistencePort;

    @InjectMocks
    RestaurantUseCase restaurantUseCase;

    static RestaurantModel restaurantModel;
    Pageable pageable;
    @BeforeAll
    static void setUp() {
        restaurantModel=new RestaurantModel();
        restaurantModel.setNumberPhone("3003735155");
        restaurantModel.setAddress("cra 54");
        restaurantModel.setName("People Pizza");
        restaurantModel.setNit("12345677");
        restaurantModel.setUrlLogo("http://localhost:8080/images/1");
    }


    @Test
    void getRestaurantById() {
        Long idRestaurant=1L;
        when(restaurantPersistencePort.getRestaurantById(idRestaurant)).thenReturn(restaurantModel);
        restaurantUseCase.getRestaurantById(idRestaurant);
        verify(restaurantPersistencePort,times(1)).getRestaurantById(idRestaurant);
    }

    @Test
    void getAllRestaurant() {
        int cant=1;
        pageable= PageRequest.of(0,cant, Sort.by("name").ascending());
        when(restaurantPersistencePort.getAllRestaurant(pageable)).thenReturn(Page.empty());
        restaurantUseCase.getAllRestaurant(cant);
        verify(restaurantPersistencePort,times(1)).getAllRestaurant(pageable);
    }

    @Test
    void saveRestaurant() {
        doNothing().when(restaurantPersistencePort).saveRestaurant(restaurantModel);
        restaurantUseCase.saveRestaurant(restaurantModel);
        verify(restaurantPersistencePort,times(1)).saveRestaurant(restaurantModel);
    }

    @Test
    void updateRestaurant() {
        restaurantModel.setId(1L);
        doNothing().when(restaurantPersistencePort).updateRestaurant(restaurantModel);
        restaurantUseCase.updateRestaurant(restaurantModel);
        verify(restaurantPersistencePort,times(1)).updateRestaurant(restaurantModel);
    }

    @Test
    void deleteRestaurant() {
        Long id=1L;
        doNothing().when(restaurantPersistencePort).deleteRestaurant(id);
        restaurantUseCase.deleteRestaurant(id);
        verify(restaurantPersistencePort,times(1)).deleteRestaurant(id);
    }
}