package com.project.onlyForKoreans.repository;

import com.project.onlyForKoreans.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
//    Optional<Comment> findById(Long id);

//    Optional<Comment> findAllBy(Long board);

    @Query("SELECT b FROM Comment b WHERE (b.board.id = :board)")
    List<Comment> findCommentAll(Long board);
}
