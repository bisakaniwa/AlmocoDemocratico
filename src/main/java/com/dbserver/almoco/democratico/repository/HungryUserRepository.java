package com.dbserver.almoco.democratico.repository;

import com.dbserver.almoco.democratico.model.HungryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HungryUserRepository extends JpaRepository<HungryUser, Long> {

    Optional<HungryUser> findByEmail(String email);
}
