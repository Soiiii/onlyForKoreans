package com.project.onlyForKoreans.repository;

import com.project.onlyForKoreans.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    Optional<Country> findByName(String countryName);
}
