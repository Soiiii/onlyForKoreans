package com.project.onlyForKoreans.controller;

import com.project.onlyForKoreans.config.auth.PrincipalDetail;
import com.project.onlyForKoreans.model.Board;
import com.project.onlyForKoreans.model.Bookmark;
import com.project.onlyForKoreans.repository.BoardRepository;
import com.project.onlyForKoreans.repository.BookmarkRepository;
import com.project.onlyForKoreans.repository.UserRepository;
import com.project.onlyForKoreans.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @GetMapping("/auth/joinForm")
    public String joinForm(Model model){
        model.addAttribute("object", userService.findCountry());

        return "user/joinForm";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "exception", required = false) String exception,
                            Model model){
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String updateForm(){
        return "user/updateForm";
    }

    @GetMapping("/user/myPage")
    public String myPage(PrincipalDetail detail, Model model){
        PrincipalDetail user = (PrincipalDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("board", boardRepository.findFilteredBoardsUser(user.getUser().getId()));
        return "user/myPage";
    }

    @GetMapping("/user/bookmark")
    public String bookmark(Model model){
        PrincipalDetail user = (PrincipalDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("user", userRepository.findById(user.getUser().getId()));
        Long userId = user.getUser().getId();

        List<Bookmark> bookmarkListFromQuery = bookmarkRepository.findUser(userId);
        System.out.println("bookmarkListFromQuery:" + bookmarkListFromQuery);
        System.out.println("bookmarkListFromQuery.get(0).getBoard():" +bookmarkListFromQuery.get(0).getBoard());
        System.out.println("bookmarkListFromQuery.get(1).getBoard():" +bookmarkListFromQuery.get(1).getBoard());
        Board board = null;
        for (int i=0; i<bookmarkListFromQuery.size(); i++)
            board = bookmarkListFromQuery.get(i).getBoard();
//            List<Board> boardList = board.setBookmarkList();
//        Optional<Bookmark> bookmarkList = bookmarkRepository.findByUser(userId);

//        System.out.println("bookmarkList:"+bookmarkList);
        for (int i=0; i<bookmarkListFromQuery.size(); i++)
            model.addAttribute("bookmark", bookmarkListFromQuery.get(i).getBoard());

        return "user/bookmark";
    }

    @GetMapping("/user/updateUser")
    public String updateUser(Model model){
        PrincipalDetail user = (PrincipalDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userService.findCounryId(user);

        model.addAttribute("object", userService.findCountry());

        return "user/updateUser";
    }

}
