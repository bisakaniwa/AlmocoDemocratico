package com.dbserver.almoco.democratico.service.impl;

import com.dbserver.almoco.democratico.model.BrazilState;
import com.dbserver.almoco.democratico.repository.BrazilStateRepository;
import com.dbserver.almoco.democratico.service.BrazilStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrazilStateServiceImpl implements BrazilStateService {

    BrazilStateRepository brazilStateRepository;

    @Autowired
    public BrazilStateServiceImpl(BrazilStateRepository brazilStateRepository) {
        this.brazilStateRepository = brazilStateRepository;
    }

    public List<BrazilState> findAllBrazilState() {
        return brazilStateRepository.findAll();
    }

    @Override
    public Optional<BrazilState> findByState(String stateName) {
        return brazilStateRepository.findBrazilStateByStateIgnoreCase(stateName);
    }

    @Override
    public BrazilState create(BrazilState brazilState) {
        return brazilStateRepository.save(brazilState);
    }
}
