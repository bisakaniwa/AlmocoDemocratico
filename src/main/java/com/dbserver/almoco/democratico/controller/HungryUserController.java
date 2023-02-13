package com.dbserver.almoco.democratico.controller;

import com.dbserver.almoco.democratico.model.HungryUser;
import com.dbserver.almoco.democratico.model.Restaurant;
import com.dbserver.almoco.democratico.model.dtos.HungryUserDTO;
import com.dbserver.almoco.democratico.model.dtos.RestaurantDTO;
import com.dbserver.almoco.democratico.service.impl.HungryUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/users")
@RestController
@CrossOrigin({"http://localhost:3000"})
public class HungryUserController {
    HungryUserServiceImpl hungryUserService;
    @Autowired
    public HungryUserController(HungryUserServiceImpl hungryUserService) {

        this.hungryUserService = hungryUserService;
    }
    @PostMapping("/register")
    public HungryUserDTO createUser(@RequestBody HungryUser hungryUser) {
        HungryUser createdUser = hungryUserService.create(hungryUser);
        return new HungryUserDTO(createdUser);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody HungryUser hungryUser) {
        Optional<HungryUser> foundUser = hungryUserService
                .findHungryUserByEmail(hungryUser.getEmail());

        if (foundUser.isPresent() && foundUser.get().getPassword()
                .equals(hungryUser.getPassword())) {
            return true;
        }
        return false;
    }

    @GetMapping("/all")
    public List<HungryUserDTO> findAllHungryUser(){
        List<HungryUser> users = hungryUserService.findAllHungryUser();
        List<HungryUserDTO> userDTOs = new ArrayList<>();
        for (HungryUser user : users) {
            userDTOs.add(new HungryUserDTO(user));
        }
        return userDTOs;
    }

    @GetMapping("/{email}/added-restaurants")
    public List<Restaurant> getAddedRestaurantsForUser(@PathVariable String email) {
        return hungryUserService.findAddedRestaurantsByEmail(email);
    }

}
