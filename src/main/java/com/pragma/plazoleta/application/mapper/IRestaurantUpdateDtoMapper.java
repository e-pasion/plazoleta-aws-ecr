package com.pragma.plazoleta.application.mapper;

import com.pragma.plazoleta.application.dto.RestaurantUpdateDto;
import com.pragma.plazoleta.domain.model.RestaurantModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantUpdateDtoMapper {
    RestaurantModel toRestaurantModel(RestaurantUpdateDto restaurantDto);
}
