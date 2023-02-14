package com.dbserver.almoco.democratico.controller;

import com.dbserver.almoco.democratico.model.BrazilCity;
import com.dbserver.almoco.democratico.model.BrazilState;
import com.dbserver.almoco.democratico.service.BrazilCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/brazil-cities")
@RestController
@CrossOrigin("http://localhost:3000")
public class BrazilCityController {

    BrazilCityService brazilCityService;
    @Autowired
    public BrazilCityController(BrazilCityService brazilCityService) {
        this.brazilCityService = brazilCityService;
    }

    @PostMapping("/register")
    public BrazilCity createBrazilCity(@RequestBody BrazilCity brazilCity){
        BrazilCity createdCity = brazilCityService.create(brazilCity);
        return createdCity;
    }

    @GetMapping("/{state}")
    public List<BrazilCity> findBrazilCityByState(@PathVariable String state){
        List<BrazilCity> brazilCityListByState = brazilCityService.findBrazilCityByState(state);
        return brazilCityListByState;
    }
    @GetMapping("/{state}/all-cities")
    public List<BrazilCity> getCitiesByStateAndCityName(@PathVariable String state) {
        return brazilCityService.findAllCityNameByStateIgnoreCase(state);
    }


}
