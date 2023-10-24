package com.project.onlyForKoreans.service;

import com.project.onlyForKoreans.model.Board;
import com.project.onlyForKoreans.model.Comment;
import com.project.onlyForKoreans.model.User;
import com.project.onlyForKoreans.repository.BoardRepository;
import com.project.onlyForKoreans.repository.CommentRepository;
import com.project.onlyForKoreans.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Comment> findAll(){
//        Board board = boardRepository.findById(boardId).orElseThrow(()->
//                new IllegalStateException("해당 게시물이 존재하지 않습니다."));

//        List<Comment> commentList = commentRepository.findCommentAll(boardId);
        return null;
    }

    @Transactional
    public void write(Long boardId, Long userId, String content) {
        System.out.println("service");
        Comment comment = new Comment();
        Optional<User> user = userRepository.findById(userId);
        Optional<Board> board = boardRepository.findById(boardId);

        comment.setContent(content);
        comment.setUser(user.get());
        comment.setBoard(board.get());
        commentRepository.save(comment);
    }

    public List<Comment> findComment(Long id) {
        List<Comment> commentList = commentRepository.findCommentAll(id);
        return commentList;
    }
}
