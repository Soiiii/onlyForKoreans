package com.project.onlyForKoreans.controller.api;

import com.project.onlyForKoreans.dto.ResponseDto;
import com.project.onlyForKoreans.dto.UserDto;
import com.project.onlyForKoreans.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {
    @Autowired
    private UserService userService;

//    @PostMapping("/auth/joinProc")
//    public ResponseDto<Integer> save(@RequestBody User user){
//        System.out.println("UserApiController: save 호출");
//        user.setRole(RoleType.USER);
//        user.setCountry((Country) user.getCountry());
//        userService.join(user);
//        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//    }

    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody UserDto userdto){
        userService.join(userdto);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}
