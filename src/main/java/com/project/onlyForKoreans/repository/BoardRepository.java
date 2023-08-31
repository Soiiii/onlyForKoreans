package com.project.onlyForKoreans.repository;

import com.project.onlyForKoreans.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    @Query("SELECT b FROM Board b WHERE (:country IS NULL AND b.category.id = :category) OR (:category IS NULL AND b.country.id = :country)")
    List<Board> findFilteredBoards(Long category, Long country);

    @Query("SELECT b FROM Board b WHERE (:country IS NULL OR b.country.id = :country)")
    List<Board> findFilteredBoardsCountry(Long country);

    Optional<Board> findById(Long id);
    void deleteById(Long id);
}