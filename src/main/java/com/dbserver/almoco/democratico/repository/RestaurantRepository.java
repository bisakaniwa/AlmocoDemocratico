package com.dbserver.almoco.democratico.repository;

import com.dbserver.almoco.democratico.model.dtos.RestaurantDTO;
import com.dbserver.almoco.democratico.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> findRestaurantByNameContainingIgnoreCase(String name);

    Optional<Restaurant> findRestaurantByAddressContainingIgnoreCase(String address);

    List<Restaurant> findRestaurantByEmail(String email);
}
