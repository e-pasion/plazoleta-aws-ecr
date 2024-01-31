package com.pragma.plazoleta.infrastructure.input.rest;

import com.pragma.plazoleta.application.dto.RestaurantDto;
import com.pragma.plazoleta.application.dto.RestaurantUpdateDto;
import com.pragma.plazoleta.application.handler.IRestaurantHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/restaurant")
public class RestaurantRestController {
    private final IRestaurantHandler restaurantHandler;

    @Operation(summary = "Add a new restaurant", description = "Creates a new restaurant in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Restaurant created", content = @Content),
    })
    @PostMapping
    public ResponseEntity<Void> saveRestaurant(@RequestBody RestaurantDto restaurant){
        restaurantHandler.saveRestaurant(restaurant);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @Operation(summary = "Update a restaurant", description = "Updates a restaurant in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Restaurant updated", content = @Content),
    })
    @PutMapping
    public ResponseEntity<Void> updateRestaurant(@RequestBody RestaurantUpdateDto restaurant){
        restaurantHandler.updateRestaurant(restaurant);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Delete a restaurant", description = "Deletes a restaurant in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Restaurant deleted", content = @Content),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id){
        restaurantHandler.deleteRestaurant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Get a restaurant", description = "Gets a restaurant in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Restaurant", content = @Content),
    })
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> getRestaurant(@PathVariable Long id){
        return ResponseEntity.ok(restaurantHandler.getRestaurantById(id));
    }

    @Operation(summary = "List restaurants", description = "List restaurants in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Restaurants list", content = @Content),
    })
    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants(){
        return ResponseEntity.ok(restaurantHandler.getAllRestaurant(100));
    }
}
