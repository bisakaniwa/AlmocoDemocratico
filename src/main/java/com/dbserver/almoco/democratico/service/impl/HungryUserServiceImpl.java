package com.dbserver.almoco.democratico.service.impl;

import com.dbserver.almoco.democratico.model.HungryUser;
import com.dbserver.almoco.democratico.model.Restaurant;
import com.dbserver.almoco.democratico.model.dtos.RestaurantDTO;
import com.dbserver.almoco.democratico.repository.HungryUserRepository;
import com.dbserver.almoco.democratico.repository.RestaurantRepository;
import com.dbserver.almoco.democratico.service.HungryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HungryUserServiceImpl implements HungryUserService {
    HungryUserRepository hungryUserRepository;
    RestaurantRepository restaurantRepository;

    @Autowired
    public HungryUserServiceImpl(HungryUserRepository hungryUserRepository, RestaurantRepository restaurantRepository) {
        this.hungryUserRepository = hungryUserRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<HungryUser> findAllHungryUser() {
        return hungryUserRepository.findAll();
    }

    @Override
    public HungryUser create(HungryUser hungryUser) {
        return hungryUserRepository.save(hungryUser);
    }

    @Override
    public Optional<HungryUser> findHungryUserByEmail(String email) {
        return hungryUserRepository.findHungryUserByEmail(email);
    }

    public List<Restaurant> findAddedRestaurantsByEmail(String email) {
        Optional<HungryUser> userEmail = hungryUserRepository.findHungryUserByEmail(email);
        List<Restaurant> restaurantList = restaurantRepository.findRestaurantByEmail(userEmail.toString());
        return restaurantList;
    }

}

