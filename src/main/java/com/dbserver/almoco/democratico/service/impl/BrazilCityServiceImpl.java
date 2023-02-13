package com.dbserver.almoco.democratico.service.impl;

import com.dbserver.almoco.democratico.model.BrazilCity;
import com.dbserver.almoco.democratico.repository.BrazilCityRepository;
import com.dbserver.almoco.democratico.service.BrazilCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrazilCityServiceImpl implements BrazilCityService {

    BrazilCityRepository brazilCityRepository;

    @Autowired
    public BrazilCityServiceImpl(BrazilCityRepository brazilCityRepository) {
        this.brazilCityRepository = brazilCityRepository;
    }

    @Override
    public List<BrazilCity> findBrazilCityByState(String state) {
        return brazilCityRepository.findByState(state);
    }


    public List<BrazilCity> findCitiesByStateAndCityName(String state, String cityName) {
        return brazilCityRepository.findByStateIgnoreCaseAndCityNameContainingIgnoreCase(state, cityName);
    }

    @Override
    public BrazilCity create(BrazilCity brazilCity) {
        return brazilCityRepository.save(brazilCity);
    }
}
