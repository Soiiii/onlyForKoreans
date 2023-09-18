package com.project.onlyForKoreans.repository;

import com.project.onlyForKoreans.model.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Integer> {
    @Query("SELECT b FROM Bookmark b WHERE (b.user.id = :user AND b.board.id = :board)")
    List<Bookmark> findUserAndBoard(Long board, Long user);

    @Modifying
    @Query("DELETE FROM Bookmark b WHERE b.board.id = :board AND b.user.id = :user")
    void deleteByBoardAndUser(Long board, Long user);

}
