package com.project.onlyForKoreans.controller.api;

import com.project.onlyForKoreans.config.auth.PrincipalDetail;
import com.project.onlyForKoreans.dto.BoardDto;
import com.project.onlyForKoreans.dto.ResponseDto;
import com.project.onlyForKoreans.model.Board;
import com.project.onlyForKoreans.model.Category;
import com.project.onlyForKoreans.model.Country;
import com.project.onlyForKoreans.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardApiController {
    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board")
    private ResponseDto<Integer> save (@RequestBody BoardDto boardDto,
                                       @AuthenticationPrincipal PrincipalDetail principal){
        System.out.println("@@Controller");
        Board board = boardDto.getBoard();
        Country country = boardDto.getCountry();
        Category category = boardDto.getCategory();
        System.out.println("boardDto:" + boardDto);
        System.out.println("board:" + board + " user:" + principal.getUser() + " country:" +country + " category:" +category);
        boardService.write(board, principal.getUser(), country, category);

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
