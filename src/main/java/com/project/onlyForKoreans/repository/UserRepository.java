package com.project.onlyForKoreans.repository;

import com.project.onlyForKoreans.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Override
    List<User> findAllById(Iterable<Integer> integers);
    Optional<User> findByEmail (String email);

}
