package com.dbserver.almoco.democratico.repository;

import com.dbserver.almoco.democratico.model.HungryUser;
import com.dbserver.almoco.democratico.model.dtos.RestaurantDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HungryUserRepository extends JpaRepository<HungryUser, Long> {

    Optional<HungryUser> findHungryUserByEmail(String email);

    List<RestaurantDTO> findAddedRestaurantsByEmail(String email);
}
