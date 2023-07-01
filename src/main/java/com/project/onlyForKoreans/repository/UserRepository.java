package com.project.onlyForKoreans.repository;

import com.project.onlyForKoreans.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
