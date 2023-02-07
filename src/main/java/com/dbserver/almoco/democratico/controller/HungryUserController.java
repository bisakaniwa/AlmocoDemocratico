package com.dbserver.almoco.democratico.controller;

import com.dbserver.almoco.democratico.service.HungryUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/user")
@RestController
public class HungryUserController {
    HungryUserService hungryUserService;

    public HungryUserController(HungryUserService hungryUserService) {
        this.hungryUserService = hungryUserService;
    }

    @GetMapping
}
