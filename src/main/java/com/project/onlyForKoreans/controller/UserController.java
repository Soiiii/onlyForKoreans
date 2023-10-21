package com.project.onlyForKoreans.controller;

import com.project.onlyForKoreans.config.auth.PrincipalDetail;
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
        model.addAttribute("bookmark", userService.findBookmark());
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
