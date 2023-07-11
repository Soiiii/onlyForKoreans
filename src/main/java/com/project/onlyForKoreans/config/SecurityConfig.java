package com.project.onlyForKoreans.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration // IoC
public class SecurityConfig {

    @Bean
    BCryptPasswordEncoder encode() {
        String encPassword = new BCryptPasswordEncoder().encode("1234");
        return new BCryptPasswordEncoder();
    }
//
//    @Bean
//    SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/auth/**", "/js/**", "/css/**", "*/image")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/auth/loginForm")
//                .loginProcessingUrl("/auth/loginProc")
//                .defaultSuccessUrl("/");
//        return http.build();
//    }
}