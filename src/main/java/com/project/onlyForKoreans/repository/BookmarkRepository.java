package com.project.onlyForKoreans.repository;

import com.project.onlyForKoreans.model.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, Integer> {
    @Query("SELECT b FROM Bookmark b WHERE (b.user.id = :user AND b.board.id = :board)")
    List<Bookmark> findUserAndBoard(Long board, Long user);

    @Query(value="SELECT b FROM Bookmark b WHERE (b.user.id = :user)")
    List<Bookmark> findUser(@Param("user") Long user);

    Optional<Bookmark> findByUser(Long user);

    @Transactional
    @Modifying
    @Query("DELETE FROM Bookmark WHERE board.id = :board AND user.id = :user")
    void deleteByBoardAndUser(Long board, Long user);

}
