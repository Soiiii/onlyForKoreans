package com.project.onlyForKoreans.controller;

import com.project.onlyForKoreans.repository.CommentRepository;
import com.project.onlyForKoreans.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;

    //게시판 메인
//    @GetMapping({"/comment"})
//    public String comment(@RequestParam(required = false) Long boardId, Model model)
//    {
//        model.addAttribute("board", commentService.findAll());
//        return "/board/board";
//    }
}
