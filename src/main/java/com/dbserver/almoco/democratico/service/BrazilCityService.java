package com.dbserver.almoco.democratico.service;

import com.dbserver.almoco.democratico.model.BrazilCity;

import java.util.List;
import java.util.Optional;

public interface BrazilCityService {

    List<BrazilCity> findBrazilCityByState(String state);
    public List<BrazilCity> findCitiesByStateAndCityName(String state, String cityName);
    BrazilCity create(BrazilCity brazilCity);
}
