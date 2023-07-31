package com.project.onlyForKoreans.controller.api;

import com.project.onlyForKoreans.config.auth.PrincipalDetail;
import com.project.onlyForKoreans.dto.ResponseDto;
import com.project.onlyForKoreans.model.Board;
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
    private ResponseDto<Integer> save (@RequestBody Board board,
                                       @AuthenticationPrincipal PrincipalDetail principal,
                                       @RequestBody Country country){
        System.out.println("Board HERE");
        boardService.write(board, principal.getUser(), country);

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
