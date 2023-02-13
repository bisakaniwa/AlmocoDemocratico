package com.dbserver.almoco.democratico.service;


import com.dbserver.almoco.democratico.model.HungryUser;
import com.dbserver.almoco.democratico.model.Restaurant;

import java.time.LocalDateTime;

public interface VoteService {
    public void vote(HungryUser hungryUser, Restaurant restaurant, LocalDateTime voteDateTime);

}
