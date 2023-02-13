package com.dbserver.almoco.democratico.service;

import com.dbserver.almoco.democratico.model.BrazilState;

import java.util.List;
import java.util.Optional;

public interface BrazilStateService {

    List<BrazilState> findAllBrazilState();

    Optional<BrazilState> findByState(String state);

    BrazilState create(BrazilState brazilState);

}
