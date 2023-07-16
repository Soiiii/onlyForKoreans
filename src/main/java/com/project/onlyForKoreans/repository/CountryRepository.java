package com.project.onlyForKoreans.repository;

import com.project.onlyForKoreans.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Override
    List<Country> findAllById(Iterable<Integer> integers);
//
//    @Override
//    List<Country> findAll();
    Optional<Country> findByName(String countryName);


}
