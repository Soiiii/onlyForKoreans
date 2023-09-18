package com.project.onlyForKoreans.repository;

import com.project.onlyForKoreans.model.Board;
import com.project.onlyForKoreans.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByName(String categoryName);

    @Query("SELECT b FROM Board b WHERE (b.user.id = :user)")
    List<Board> findFilteredBoardsUser(Long user);

}
