package com.dbserver.almoco.democratico.service;

import com.dbserver.almoco.democratico.model.HungryUser;
import com.dbserver.almoco.democratico.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface HungryUserService {
    public List<HungryUser> findAllHungryUser();

    public HungryUser create(HungryUser hungryUser);

    public Optional<HungryUser> findHungryUserByEmail(String email);

    public List<Restaurant> findAddedRestaurantsByEmail(String email);
}
