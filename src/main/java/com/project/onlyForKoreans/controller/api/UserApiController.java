package com.project.onlyForKoreans.controller.api;

import com.project.onlyForKoreans.dto.ResponseDto;
import com.project.onlyForKoreans.dto.UserDto;
import com.project.onlyForKoreans.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class UserApiController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

//    @PostMapping("/auth/joinProc")
//    public ResponseDto<Integer> save(@RequestBody UserDto userdto){
//        userService.join(userdto);
//        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//    }


    @PostMapping("/auth/joinProc")
    public ResponseDto<?> save(@Valid @RequestBody UserDto userdto, Errors errors, Model model){
        System.out.println("userDto:" + userdto);
        System.out.println("errors:" + errors);
        String errorMessages = null;
        //에러가 날시에 에러 문구 표시
        if(errors.hasErrors()){
            Map<String, String> validatorResult = userService.validateHandling(errors);
            for (String key: validatorResult.keySet()) {
                errorMessages = validatorResult.get(key);
                System.out.println("key:" + key);
                System.out.println("validatorResult.get(key):"+validatorResult.get(key));
            }
            //에러가 날시에 404에러와 함께 errorMessage 전송
            return new ResponseDto<Integer>(HttpStatus.NOT_FOUND.value(), 0, errorMessages);
        }
        userService.join(userdto);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);

    }

    //    @PostMapping("/auth/joinProc")
//    public ResponseDto<Integer> save(@RequestBody @Valid UserDto userdto, Errors errors, Model model){
//        System.out.println("userdto:"+userdto);
//        System.out.println("errors:" + errors);
//        if(errors.hasErrors()){
//
//            model.addAttribute("userDto", userdto);
//            Map<String, String> validatorResult = userService.validateHandling(errors);
//            String errorMessages = null;
//            for (String key: validatorResult.keySet()) {
////                System.out.println("key:" + key);
//                errorMessages = validatorResult.get(key);
////                model.addAttribute(key, validatorResult.get(key));
//            }
////            return "user/joinForm";
//            return new ResponseDto<Integer>(HttpStatus.NOT_FOUND.value(), errorMessages);
//
//        }
//
//        userService.join(userdto);
////        return "index";
//        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//
//    }

}
