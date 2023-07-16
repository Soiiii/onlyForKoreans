package com.project.onlyForKoreans.config.auth;

import com.project.onlyForKoreans.model.User;
import com.project.onlyForKoreans.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service //IOC
public class PrincipalDetailService implements UserDetailsService {


    @Autowired //DI
    private UserRepository userRepository;

    // 스프링이 로그인 요청을 가로챌때 username과 password 변수 2개를 가로챔
    // 패스워드 부분 처리를 알아서 해줌
    // username이 DB에 있는지만 확인해 주면됨

    //그 확인을 이 함수에서 처리
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->{
                    return new UsernameNotFoundException("Not found");
                });

        return new PrincipalDetail(user);
    }
}