package com.project.onlyForKoreans.controller;

import com.project.onlyForKoreans.model.User;
import com.project.onlyForKoreans.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/auth/joinForm")
    public String joinForm(){
        return "user/joinForm";
    }

    @GetMapping("/auth/loginProc")
    public String loginForm(){
        System.out.println("@@@@@loginform");
        return "user/loginForm";
    }

    @PostMapping("/auth/loginForm")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session){
        User user = userRepository.findByEmail(email);
        if(email != null && user.getPassword().equals(password)){
            session.setAttribute("user", user);
            return "redirect:index";
        } else{
            return "redirect:user/loginForm?error";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:index";
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
