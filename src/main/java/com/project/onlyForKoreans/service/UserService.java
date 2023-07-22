package com.project.onlyForKoreans.service;

import com.project.onlyForKoreans.dto.UserDto;
import com.project.onlyForKoreans.model.Country;
import com.project.onlyForKoreans.model.RoleType;
import com.project.onlyForKoreans.model.User;
import com.project.onlyForKoreans.repository.CountryRepository;
import com.project.onlyForKoreans.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private CountryRepository countryRepository;

//    @Transactional
//    public void join(User user){
//        String rawPassword = user.getPassword();
//        // TODO: 패스워드 인코딩 하는거 추가
//        Country country = user.getCountry();
//        String name = user.getName();
//
////        System.out.println("country:" +country);
//
//        user.setName(name);
//        user.setPassword(rawPassword);
////        country.setCountry(country);
//        userRepository.save(user);
//        System.out.println("RawPassword:" +rawPassword);
////        System.out.println("EncPassword:" +encPassword);
//
//    }
    @Transactional
    public void join(UserDto userdto){
        String email = userdto.getEmail();
        // TODO: 패스워드 인코딩 하는거 추가
        String rawPassword = userdto.getPassword();
        String encPassword = encoder.encode(rawPassword);
        String countryName = userdto.getCountry();
        String name = userdto.getName();

        Country country = null;
        Optional<Country> countryObj = countryRepository.findByName(countryName);
        if (countryObj.isPresent()) {
            country = countryObj.get();
            // 국가 정보를 사용하여 원하는 작업 수행
        } else {
            // 국가가 존재하지 않는 경우에 대한 처리
        }
        User user = new User();
        user.setUsername(name);
        user.setPassword(encPassword);
        user.setEmail(email);
        user.setRole(RoleType.USER);
        user.setCountry(country);
        userRepository.save(user);

        System.out.println("RawPassword:" +rawPassword);
//        System.out.println("EncPassword:" +encPassword);

    }



//    @Transactional
//    public void login(User user){
//        String email = user.getEmail();
//        String password = user.getPassword();
////        userRepository.findAllById(email);
//        System.out.println("email:" +email + "password:" + password);
//
//    }

    public List<Country> findCountry(){
        System.out.println();
        return countryRepository.findAll();
    }

}
