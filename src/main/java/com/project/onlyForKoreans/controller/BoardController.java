package com.project.onlyForKoreans.controller;

import com.project.onlyForKoreans.model.Board;
import com.project.onlyForKoreans.repository.BoardRepository;
import com.project.onlyForKoreans.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

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
        model.addAttribute("country", boardService.findCountry());
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

    @GetMapping("/category")
//    @ResponseBody
    public String showPostsByCategory(@RequestParam(required = false) Long category, @RequestParam(required = false) Long country, Model model) {
        System.out.println("category:" + category);
        System.out.println("country:" + country);
        List<Board> boardsList = boardRepository.findFilteredBoards(category, country);

        // category, country 값이 null일때 (전체 리스트값 출력)
//        if(category.isEmpty() && country.isEmpty()){
            // 전체 리스트 출력
//            boardsList = boardService.list();
//        } else if(!category.isEmpty() && country.isEmpty()){
            // category 필터링
//            boardsList = boardService.list().stream()
//                    .filter(board -> board.getCategory().getName().equalsIgnoreCase(category))
//                    .collect(Collectors.toList());
//            for (Board board : boardsInCategory) {
//                htmlContent.append("<div class='filtered-board'>");
//                htmlContent.append("<div class=\"col-sm-6\">");
//                htmlContent.append("<a href='/board/" + board.getId() + "'>");
//                htmlContent.append("<c:if test=\"${status.index % 2 == 0}\">");
//                htmlContent.append("<div class=\"row\">");
//                htmlContent.append("</c:if>");
//                htmlContent.append("<p>").append(board.getCategory().getName()).append("</p>");
//                htmlContent.append("<h3>").append(board.getTitle()).append("</h3>");
//                htmlContent.append("<p>").append(board.getContent()).append("</p>");
//                htmlContent.append("<p>View:").append(board.getCount()).append("</p>");
//                htmlContent.append("<p>Created:").append(board.getCreate_at()).append("</p>");
//                htmlContent.append("</a>");
//                htmlContent.append("</div>");
//                htmlContent.append("</div>");
//            }
//        }
//        else if(category.isEmpty() && !country.isEmpty()){
            // country 필터링
//            boardsList = boardService.();
//            boardsList = boardService.list().stream()
//                    .filter(board -> board.getCountry().getName().equalsIgnoreCase(country))
//                    .collect(Collectors.toList());
//        }

        System.out.println("boardsList:"+boardsList);
        // 필터링된 글 목록을 HTML로 변환하여 반환
        model.addAttribute("boardsList", boardsList);
        return "board/board";
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
