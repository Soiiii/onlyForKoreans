package com.project.onlyForKoreans.controller;

import com.project.onlyForKoreans.model.Board;
import com.project.onlyForKoreans.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    //메인페이지
    @GetMapping({"/"})
    public String index(Model model)
//    public String index(Model model, @PageableDefault(size=3, sort="id", direction= Sort.Direction.DESC) Pageable pageable)
    {
        System.out.println("boardService.list():" +boardService.list());
        model.addAttribute("boards", boardService.list());
//        model.addAttribute("boards", boardService.list(pageable));
        return "index";
    }

    //게시판 메인
//    @GetMapping({"/board"})
//    public String board(Model model)
//    {
//        model.addAttribute("board", boardService.list());
//        model.addAttribute("category", boardService.findCategory());
//        return "/board/board";
//    }

    //게시판 메인
    @GetMapping({"/board"})
    public String board(Model model)
    {
        model.addAttribute("board", boardService.list());
        model.addAttribute("category", boardService.findCategory());
        return "/board/board";
    }

    //게시판 카테고리 선택시 보여줄 페이지
    @GetMapping("/board/{category}")
    public String findByCategoryId(@RequestParam String category, Model model){
//        if(categoryId.equals("이야기")){
//            model.addAttribute("items", boardService.findCategory().get(0));
//        } else if(categoryId.equals("연애")){
//            model.addAttribute("items", boardService.findCategory().get(1));
//        }
//        model.addAttribute("board", boardService.findCategory());
        List<Board> postsInCategory = boardService.list().stream()
                .filter(board -> boardService.findCategory().equals(category))
                .collect(Collectors.toList());

        model.addAttribute("posts", postsInCategory);

        return "/board/board";
    }


    //글 저장
    @GetMapping("/board/saveForm")
    public String saveForm(Model model) {
        model.addAttribute("object", boardService.findCountry());
        model.addAttribute("category", boardService.findCategory());
        return "board/saveForm";
    }

    //게시판 상세 페이지
    @GetMapping("/board/{id}")
    public String findById(@PathVariable Long id, Model model){
        model.addAttribute("board", boardService.details(id));
        return "board/detail";
    }

    //게시판 수정 페이지
    @GetMapping("/board/{id}/updateForm")
    public String updateForm(@PathVariable Long id, Model model){
        model.addAttribute("board", boardService.details(id));
        return "board/updateForm";
    }

    @GetMapping({"/board/Thailand"})
    public String boardThailand()
    {
        return "/board/Thailand";
    }

    @GetMapping({"/board/Vietnam"})
    public String boardVietnam()
    {
        return "/board/Vietnam";
    }

    @GetMapping({"/board/Singapore"})
    public String boardSingapore()
    {
        return "/board/Singapore";
    }

    @GetMapping({"/board/China"})
    public String boardChina()
    {
        return "/board/China";
    }

    @GetMapping({"/board/Japan"})
    public String boardJapan()
    {
        return "/board/Japan";
    }

    @GetMapping({"/notice"})
    public String notice()
    {
        return "/notice/notice";
    }

    @GetMapping({"/notice/issue"})
    public String issue()
    {
        return "/notice/issue";
    }
}
