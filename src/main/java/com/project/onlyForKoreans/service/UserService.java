package com.project.onlyForKoreans.service;

import com.project.onlyForKoreans.config.auth.PrincipalDetail;
import com.project.onlyForKoreans.dto.UserDto;
import com.project.onlyForKoreans.model.Country;
import com.project.onlyForKoreans.model.RoleType;
import com.project.onlyForKoreans.model.User;
import com.project.onlyForKoreans.repository.BoardRepository;
import com.project.onlyForKoreans.repository.CountryRepository;
import com.project.onlyForKoreans.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private BoardRepository boardRepository;
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

    @Transactional(readOnly = true)
    public Map<String, String> validateHandling(Errors errors){
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError error: errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
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
        return countryRepository.findAll();
    }

    // User country update시에 principalDetail의 user.country를 함께 수정해줌
    // DB와 값 동기화가 바로 안됨
    public void findCounryId(PrincipalDetail user){
        Optional<User> dataUser = userRepository.findById(user.getUser().getId());

        System.out.println("dataUser.get().getCountry():" + dataUser.get().getCountry());
        user.getUser().setCountry(dataUser.get().getCountry());

        // Clear the authentication cache
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        authentication.setAuthenticated(false);
//        SecurityContextHolder.getContext().setAuthentication(null);
    }


    public void updateUser(UserDto userDto) {
        User originUser = userRepository.findByEmail(userDto.getEmail())
                        .orElseThrow(()->{
                            return new IllegalArgumentException("해당 아이디 찾기 실패");
                        });

        System.out.println("originUser:"+originUser);
        String originPassword = userDto.getPassword();
        String encPassword = encoder.encode(originPassword);

        Optional<Country> countryObj = countryRepository.findByName(userDto.getCountry());

        originUser.setCountry(countryObj.get());
        originUser.setPassword(encPassword);

        userRepository.save(originUser);
    }
}
