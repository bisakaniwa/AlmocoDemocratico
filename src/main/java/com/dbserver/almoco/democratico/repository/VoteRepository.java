package com.dbserver.almoco.democratico.repository;

import com.dbserver.almoco.democratico.model.HungryUser;
import com.dbserver.almoco.democratico.model.Restaurant;
import com.dbserver.almoco.democratico.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    boolean existsByHungryUserAndRestaurantAndVoteDateTimeBetween(HungryUser hungryUser, Restaurant restaurant,
                                                                  LocalDateTime startDateTime, LocalDateTime endDateTime);
}

