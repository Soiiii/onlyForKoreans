package com.project.onlyForKoreans.controller;

import com.project.onlyForKoreans.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping({"/"})
    public String index()
    {
        return "index";
    }

    @GetMapping({"/board"})
    public String board()
    {
        return "/board/board";
    }

    @GetMapping("/board/saveForm")
    public String saveForm(Model model){
        model.addAttribute("object", boardService.findCountry());
        model.addAttribute("category", boardService.findCategory());
        return "board/saveForm";
    }

    @GetMapping({"/board/detail"})
    public String boardDetail()
    {
        return "/board/detail";
    }

    @GetMapping({"/board/thailand"})
    public String boardThailand()
    {
        return "/board/thailand";
    }

    @GetMapping({"/board/vietnam"})
    public String boardVietnam()
    {
        return "/board/vietnam";
    }

    @GetMapping({"/board/singapore"})
    public String boardSingapore()
    {
        return "/board/singapore";
    }

    @GetMapping({"/board/china"})
    public String boardChina()
    {
        return "/board/china";
    }

    @GetMapping({"/board/japan"})
    public String boardJapan()
    {
        return "/board/japan";
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
