package com.project.onlyForKoreans.controller;

import com.project.onlyForKoreans.repository.UserRepository;
import com.project.onlyForKoreans.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String myPage(){
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
