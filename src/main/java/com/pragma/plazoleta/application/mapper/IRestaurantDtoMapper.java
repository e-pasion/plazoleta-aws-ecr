package com.pragma.plazoleta.application.mapper;

import com.pragma.plazoleta.application.dto.RestaurantDto;
import com.pragma.plazoleta.domain.model.RestaurantModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantDtoMapper {
    RestaurantModel toRestaurantModel(RestaurantDto restaurantDto);
    RestaurantDto toRestaurantDto(RestaurantModel restaurantModel);
    List<RestaurantDto> toRestaurantsDto(List<RestaurantModel> restaurantModels);
}
