package com.dbserver.almoco.democratico.repository;

import com.dbserver.almoco.democratico.model.BrazilCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrazilCityRepository extends JpaRepository<BrazilCity, Long> {

    List<BrazilCity> findByState(String stateName);

    List<BrazilCity> findAllCityNameByStateIgnoreCase(String state);
}
