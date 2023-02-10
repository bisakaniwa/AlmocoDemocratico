package com.dbserver.almoco.democratico.controller;

import com.dbserver.almoco.democratico.model.HungryUser;
import com.dbserver.almoco.democratico.service.HungryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/user")
@RestController
@CrossOrigin({"http://localhost:3000"})
public class HungryUserController {
    HungryUserService hungryUserService;
    @Autowired
    public HungryUserController(HungryUserService hungryUserService) {

        this.hungryUserService = hungryUserService;
    }
    @PostMapping("/register")
    public HungryUser createUser(@RequestBody HungryUser hungryUser) {
        return hungryUserService.create(hungryUser);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody HungryUser hungryUser) {
        Optional<HungryUser> foundUser = hungryUserService
                .findUserByEmail(hungryUser.getEmail());

        if (foundUser.isPresent() && foundUser.get().getPassword()
                .equals(hungryUser.getPassword())) {
            return true;
        }
        return false;
    }

    @GetMapping
    public List<HungryUser> findAllHungryUser(){
        return hungryUserService.findAllHungryUser();
    }

}
