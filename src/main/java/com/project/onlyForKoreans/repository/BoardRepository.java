package com.project.onlyForKoreans.repository;

import com.project.onlyForKoreans.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
}
