package com.project.onlyForKoreans.repository;

import com.project.onlyForKoreans.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    Optional<Board> findById(Long id);
}