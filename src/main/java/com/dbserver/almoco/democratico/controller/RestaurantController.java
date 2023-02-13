package com.dbserver.almoco.democratico.controller;

import com.dbserver.almoco.democratico.model.Restaurant;
import com.dbserver.almoco.democratico.model.dtos.RestaurantDTO;
import com.dbserver.almoco.democratico.service.impl.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/restaurants")
public class RestaurantController {
    private final RestaurantServiceImpl restaurantService;

    @Autowired
    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/all")
    public List<com.dbserver.almoco.democratico.model.dtos.RestaurantDTO> findAll() {
        List<Restaurant> restaurants = restaurantService.findAll();
        List<com.dbserver.almoco.democratico.model.dtos.RestaurantDTO> restaurantDTOList = new ArrayList<>();
        for (Restaurant restaurant: restaurants) {
            restaurantDTOList.add(new com.dbserver.almoco.democratico.model.dtos.RestaurantDTO(restaurant));
        }
        return restaurantDTOList;
    }

    @PostMapping("/register")
    public com.dbserver.almoco.democratico.model.dtos.RestaurantDTO create(@RequestBody Restaurant restaurant) {
        Restaurant savedRestaurant = restaurantService.create(restaurant);
        return new com.dbserver.almoco.democratico.model.dtos.RestaurantDTO(savedRestaurant);
    }

   @GetMapping("/by-name/{name}")
    public ResponseEntity<com.dbserver.almoco.democratico.model.dtos.RestaurantDTO> findRestaurantByNameContainingIgnoreCase(@PathVariable String name) {
        Optional<Restaurant> restaurantOptional = restaurantService.findRestaurantByNameContainingIgnoreCase(name);
        return restaurantOptional.map(restaurant -> ResponseEntity.ok(new com.dbserver.almoco.democratico.model.dtos.RestaurantDTO(restaurant)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/by-address/{address}")
    public ResponseEntity<com.dbserver.almoco.democratico.model.dtos.RestaurantDTO> findRestaurantByAddressContainingIgnoreCase(@PathVariable String address) {
        Optional<Restaurant> restaurantOptional = restaurantService.findRestaurantByAddressContainingIgnoreCase(address);
        return restaurantOptional.map(restaurant -> ResponseEntity.ok(new com.dbserver.almoco.democratico.model.dtos.RestaurantDTO(restaurant)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/by-user/{hungryUserEmail}")
    public List<com.dbserver.almoco.democratico.model.dtos.RestaurantDTO> getRestaurantsByHungryUser(@PathVariable String hungryUserEmail) {
        List<Restaurant> restaurants = restaurantService.findRestaurantsByEmail(hungryUserEmail);
        return restaurants.stream().map(com.dbserver.almoco.democratico.model.dtos.RestaurantDTO::new).collect(Collectors.toList());
    }

}
