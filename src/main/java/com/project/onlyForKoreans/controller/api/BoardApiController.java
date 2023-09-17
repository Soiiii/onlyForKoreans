package com.project.onlyForKoreans.controller.api;

import com.project.onlyForKoreans.config.auth.PrincipalDetail;
import com.project.onlyForKoreans.dto.BoardDto;
import com.project.onlyForKoreans.dto.BookmarkDto;
import com.project.onlyForKoreans.dto.ResponseDto;
import com.project.onlyForKoreans.model.Board;
import com.project.onlyForKoreans.model.Category;
import com.project.onlyForKoreans.model.Country;
import com.project.onlyForKoreans.repository.CategoryRepository;
import com.project.onlyForKoreans.repository.CountryRepository;
import com.project.onlyForKoreans.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BoardApiController {
    @Autowired
    private BoardService boardService;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // 글 작성
    @PostMapping("/api/board")
    private ResponseDto<Integer> save (@RequestBody BoardDto boardDto,
                                       @AuthenticationPrincipal PrincipalDetail principal){
        System.out.println("@@Controller");

        String countryName = boardDto.getCountry().getName();
        String categoryName = boardDto.getCategory().getName();
        Optional<Country> country = countryRepository.findByName(countryName);
        Optional<Category> category = categoryRepository.findByName(categoryName);System.out.println("country:" +country + " category:" +category);
        System.out.println("boardDto:" + boardDto);

        boardService.write(boardDto, principal.getUser(), country, category);

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    // 글 수정
    @PostMapping("/api/board/{id}/updateForm")
    public ResponseDto<Integer> update(@PathVariable Long id, @RequestBody Board board){
        boardService.edit(id, board);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    // 글 삭제
    @DeleteMapping("/api/board/{id}")
    private ResponseDto<Integer> deleteById(@PathVariable Long id){
        boardService.delete(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    //북마크 추가, 삭제, 조회
    @PostMapping("/api/board/bookmark")
    public ResponseDto<Integer> bookmark(@RequestBody BookmarkDto bookmarkDto){
        System.out.println("bookmark:" + bookmarkDto);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}
