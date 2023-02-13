package com.dbserver.almoco.democratico.service.impl;

import com.dbserver.almoco.democratico.model.Restaurant;
import com.dbserver.almoco.democratico.repository.RestaurantRepository;
import com.dbserver.almoco.democratico.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RestaurantServiceImpl implements RestaurantService {

    RestaurantRepository restaurantRepository;
    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public Optional<Restaurant> findRestaurantByNameContainingIgnoreCase(String name) {
        return restaurantRepository.findRestaurantByNameContainingIgnoreCase(name);
    }

    @Override
    public Optional<Restaurant> findRestaurantByAddressContainingIgnoreCase(String address) {
        return restaurantRepository.findRestaurantByAddressContainingIgnoreCase(address);
    }

    @Override
    public List<Restaurant> findRestaurantsByEmail(String email) {
        return restaurantRepository.findRestaurantByEmail(email);
    }


}
