package com.dbserver.almoco.democratico.model.dtos;

import com.dbserver.almoco.democratico.model.HungryUser;
import com.dbserver.almoco.democratico.model.Restaurant;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class HungryUserDTO {
    private String name;
    private String email;

    private List<Restaurant> addedRestaurants;


    public HungryUserDTO(HungryUser user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.addedRestaurants = user.getAddedRestaurants();
    }
}
