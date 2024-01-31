package com.pragma.plazoleta.infrastructure.out.jpa.mapper;

import com.pragma.plazoleta.domain.model.RestaurantModel;
import com.pragma.plazoleta.infrastructure.out.jpa.entity.RestaurantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRestaurantEntityMapper {
    RestaurantEntity toEntity(RestaurantModel restaurant);
    RestaurantModel toRestaurant(RestaurantEntity restaurant);
    default Page<RestaurantModel> toRestaurants(Page<RestaurantEntity> restaurantEntities) {
        return restaurantEntities.map(this::toRestaurant);
    }
}
