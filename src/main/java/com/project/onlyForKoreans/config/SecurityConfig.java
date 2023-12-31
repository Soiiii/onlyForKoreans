package com.project.onlyForKoreans.config;

import com.project.onlyForKoreans.config.auth.PrincipalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근을 하면 권한 및 인증을 미리 체크
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PrincipalDetailService principalDetailService;

    @Bean // 스프링 IOC 컨테이너에 등록
    public BCryptPasswordEncoder encodePWD(){ //비밀번호 해쉬 암호화
//        String encPassword = new BCryptPasswordEncoder().encode("1234");
//        System.out.println("encPassword: " + encPassword);
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     *   시큐리티가 대신 로그인 할때 password를 가로치기할때
     *      해당 password가 뭘로 해쉬 임호화가 되어 회원가입을 했는지 알아야
     *      같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교할 수있음
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //principalDetailService를 넣어줘야 패드워드 비교를 할 수있음
        //principalDetailService가 로그인 요청
        auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
    }

    @Bean
    public CustomAuthenticationFailureHandler customAuthenticationFailureHandler(){
        return new CustomAuthenticationFailureHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() //csrf 토큰 비활성화 (테스트시 걸어야함)
                .authorizeRequests()
                .antMatchers("/","/notice", "/board/**", "/category**","/auth/**","/js/**","/css/**","/image/**","/dummy/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .usernameParameter("email")
//                .passwordParameter("password")
                .loginPage("/auth/loginForm") //인증이 필요한 곳으로 요청이오면 자동으로 로그인 페이지 나오게 설정
                .failureHandler(customAuthenticationFailureHandler()) // 실패 시 처리할 핸들러
                .loginProcessingUrl("/auth/loginProc") //스프링 시큐리티가 해당주소로 요청오는 로그인을 가로채서 대신 로그인
                .defaultSuccessUrl("/") //로그인 성공시 기본 페이지
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");

                /*
                .csrf().disable() //csrf 토큰 비활성화 (테스트시 걸어야함)
                .authorizeRequests()
                .antMatchers("/","/auth/**","/js/**","/css/**","/image/**","/dummy/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //인증이 필요한 곳으로 요청이오면 자동으로 로그인 페이지 나오게 설정
                .loginPage("/auth/loginForm")
                .failureUrl("/auth/loginForm?error")
                //스프링 시큐리티가 해당주소로 요청오는 로그인을 가로채서 대신 로그인
                .loginProcessingUrl("/auth/loginProc")
                //로그인 성공시 기본 페이지
                .defaultSuccessUrl("/")
//                .usernameParameter("email")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll();
                */
    }
}