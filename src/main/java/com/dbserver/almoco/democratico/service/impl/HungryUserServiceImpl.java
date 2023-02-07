package com.dbserver.almoco.democratico.service.impl;

import com.dbserver.almoco.democratico.model.HungryUser;
import com.dbserver.almoco.democratico.repository.HungryUserRepository;
import com.dbserver.almoco.democratico.service.HungryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HungryUserServiceImpl implements HungryUserService {
    HungryUserRepository hungryUserRepository;

    @Autowired
    public HungryUserServiceImpl(HungryUserRepository hungryUserRepository) {
        this.hungryUserRepository = hungryUserRepository;
    }

    @Override
    public List<HungryUser> findAllHungryUser() {
        return hungryUserRepository.findAll();
    }

    @Override
    public HungryUser create(HungryUser hungryUser) {
        return hungryUserRepository.save(hungryUser);
    }

    @Override
    public Optional<HungryUser> findUserByEmail(String email) {
        return hungryUserRepository.findByEmail(email);
    }
}
