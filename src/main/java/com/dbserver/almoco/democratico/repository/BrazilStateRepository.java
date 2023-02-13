package com.dbserver.almoco.democratico.repository;

import com.dbserver.almoco.democratico.model.BrazilState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrazilStateRepository extends JpaRepository<BrazilState, String> {

    Optional<BrazilState> findBrazilStateByStateIgnoreCase(String state);

}
