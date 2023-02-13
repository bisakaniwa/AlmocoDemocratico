package com.dbserver.almoco.democratico.controller;

import com.dbserver.almoco.democratico.model.BrazilState;
import com.dbserver.almoco.democratico.service.impl.BrazilStateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/brazil-states")
@RestController
@CrossOrigin("http://localhost:3000")
public class BrazilStateController {

    BrazilStateServiceImpl brazilStateService;

    @Autowired
    public BrazilStateController(BrazilStateServiceImpl brazilStateService) {
        this.brazilStateService = brazilStateService;
    }

    @PostMapping("/register")
    public BrazilState createBrazilState(@RequestBody BrazilState brazilState){
        BrazilState createdBrazilState = brazilStateService.create(brazilState);
        return createdBrazilState;
    }

    @GetMapping("/all")
    public List<BrazilState> findAllBrazilState(){
        return brazilStateService.findAllBrazilState();
    }

    @GetMapping("/{state}")
    public Optional<BrazilState> findByState(@PathVariable String state){
        return brazilStateService.findByState(state);
    }

}
