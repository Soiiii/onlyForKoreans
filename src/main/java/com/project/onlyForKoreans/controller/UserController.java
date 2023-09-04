package com.project.onlyForKoreans.controller;

import com.project.onlyForKoreans.config.auth.PrincipalDetail;
import com.project.onlyForKoreans.repository.BoardRepository;
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

    @GetMapping("/auth/joinForm")
    public String joinForm(Model model){
        model.addAttribute("object", userService.findCountry());
        System.out.println("country 종류: " + userService.findCountry());

        return "user/joinForm";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "exception", required = false) String exception,
                            Model model){
        System.out.println("@@@@@loginform");
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        System.out.println("error?");
        return "user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String updateForm(){
        return "user/updateForm";
    }

    @GetMapping("/user/myPage")
    public String myPage(PrincipalDetail detail, Model model){
        PrincipalDetail user = (PrincipalDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("user:" + user);
        int userId = (int) user.getUser().getId();
        System.out.println("user.getUser().getId():" + user.getUser().getId());
        System.out.println("userId:" + userId);

        model.addAttribute("board", boardRepository.findFilteredBoardsUser(user.getUser().getId()));
        System.out.println("userRepository.findById(user.getUser().getId())"+boardRepository.findFilteredBoardsUser(user.getUser().getId()));
        return "user/myPage";
    }
    @GetMapping("/user/bookmark")
    public String bookmark(){
        return "user/bookmark";
    }
    @GetMapping("/user/updateUser")
    public String updateUser(){
        return "user/updateUser";
    }

}
