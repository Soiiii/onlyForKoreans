package com.project.onlyForKoreans.config;

import com.project.onlyForKoreans.config.auth.PrincipalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PrincipalDetailService principalDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() //csrf 토큰 비활성화 (테스트시 걸어야함)
                .authorizeRequests()
                .antMatchers("/","/auth/**","/js/**","/css/**","/image/**","/dummy/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //인증이 필요한 곳으로 요청이오면 자동으로 로그인 페이지 나오게 설정
                .loginPage("/auth/loginForm")
                //스프링 시큐리티가 해당주소로 요청오는 로그인을 가로채서 대신 로그인
                .loginProcessingUrl("/auth/loginProc")
                //로그인 성공시 기본 페이지
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll();
    }
}