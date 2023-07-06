package com.project.onlyForKoreans.service;

import com.project.onlyForKoreans.model.User;
import com.project.onlyForKoreans.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    @Transactional
    public void join(User user){
        String rawPassword = user.getPassword();
        // TODO: 패스워드 인코딩 하는거 추가
        String country = user.getCountry();
        System.out.println("country:" +country);

        user.setPassword(rawPassword);
        user.setCountry(country);
        userRepository.save(user);
        System.out.println("RawPassword:" +rawPassword);
//        System.out.println("EncPassword:" +encPassword);

    }


}
