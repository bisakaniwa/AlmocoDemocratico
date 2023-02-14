package com.dbserver.almoco.democratico.service.impl;

import com.dbserver.almoco.democratico.model.HungryUser;
import com.dbserver.almoco.democratico.model.Restaurant;
import com.dbserver.almoco.democratico.model.Vote;
import com.dbserver.almoco.democratico.repository.RestaurantRepository;
import com.dbserver.almoco.democratico.repository.VoteRepository;
import com.dbserver.almoco.democratico.service.VoteService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class VoteServiceImpl implements VoteService {
    private final VoteRepository voteRepository;
    private final RestaurantRepository restaurantRepository;

    public VoteServiceImpl(VoteRepository voteRepository, RestaurantRepository restaurantRepository) {
        this.voteRepository = voteRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public void vote(HungryUser hungryUser, Restaurant restaurant, LocalDateTime voteDateTime) {
        // check if the user has already voted for this restaurant today
        if (voteRepository.existsByHungryUserAndRestaurantAndVoteDateTimeBetween(hungryUser, restaurant,
                LocalDateTime.of(LocalDate.now(), LocalTime.of(8, 0)),
                LocalDateTime.of(LocalDate.now(), LocalTime.of(13, 0)))) {
            //TODO trocar mensagem de run
            throw new RuntimeException("You can only vote once per day for a restaurant or.");
        }

        // retrieve the existing restaurant record
        Optional<Restaurant> existingRestaurantOptional = restaurantRepository.findById(restaurant.getRestaurantId());
        if (existingRestaurantOptional.isEmpty()) {
            throw new RuntimeException("Restaurant not found");
        }

        // update the vote count on the existing restaurant record
        Restaurant existingRestaurant = existingRestaurantOptional.get();
        existingRestaurant.setNumVotes(existingRestaurant.getNumVotes());

        // create a new vote
        Vote vote = new Vote();
        vote.setHungryUser(hungryUser);
        vote.setRestaurant(existingRestaurant);
        vote.setVoteDateTime(voteDateTime);

        // save the vote and update the restaurant's vote count
        voteRepository.save(vote);
        restaurantRepository.save(existingRestaurant);
    }
}
