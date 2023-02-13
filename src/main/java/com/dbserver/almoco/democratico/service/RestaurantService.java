package com.dbserver.almoco.democratico.service;

import com.dbserver.almoco.democratico.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    public List<Restaurant> findAll();
    public Restaurant create(Restaurant restaurant);

    public Optional<Restaurant> findById(Long id);

    public Optional<Restaurant> findRestaurantByNameContainingIgnoreCase(String name);

    public Optional<Restaurant> findRestaurantByAddressContainingIgnoreCase(String address);

    public List<Restaurant> findRestaurantsByEmail(String email);
}
