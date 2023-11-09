package com.project.onlyForKoreans.controller.api;

import com.project.onlyForKoreans.dto.CommentDto;
import com.project.onlyForKoreans.dto.ResponseDto;
import com.project.onlyForKoreans.service.BoardService;
import com.project.onlyForKoreans.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentApiController {
    @Autowired
    private BoardService boardService;

    @Autowired
    private CommentService commentService;

    //댓글 작성
    @PostMapping("/api/comment")
    private ResponseDto<Integer> save (@RequestBody CommentDto commentDto){
        String content = commentDto.getContent();
        System.out.println("content:"+content);
        // 빈값이 들어오면 알림창
        if(content.equals("")){
            return new ResponseDto<Integer>(HttpStatus.NO_CONTENT.value(), 0);
        }

        Long boardId = commentDto.getBoard_id();
        Long userId = commentDto.getUser_id();

        commentService.write(boardId, userId, content);

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    //댓글 수정
    @PostMapping("/api/comment/edit")
    private ResponseDto<Integer> editComment (@RequestBody CommentDto commentDto) {
        System.out.println("commentDto:"+commentDto);
        Long commentId = commentDto.getCommentId();
        String content = commentDto.getContent();
        commentService.editComment(commentId, content);

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
