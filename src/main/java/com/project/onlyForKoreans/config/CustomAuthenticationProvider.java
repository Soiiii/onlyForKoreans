package com.project.onlyForKoreans.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserDetailsService userDetailsService;

//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        return null;
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return false;
//    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

//        String email = authentication.getName();
        String name = authentication.getName();
//        String password = authentication.getCredentials().toString();
        String password = authentication.toString();
        System.out.println("@@@@name:" + name +" password:" + password);

//        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        UserDetails userDetails = userDetailsService.loadUserByUsername(name);


        // 비밀번호 검증 등 사용자 인증 처리 로직 작성
        // 직접 비밀번호 비교
        if (!password.equals(userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid email or password.");
        }

        // BCryptPasswordEncoder를 사용하여 비밀번호 매칭
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
//            throw new BadCredentialsException("Invalid email or password.");
//        }

        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


}