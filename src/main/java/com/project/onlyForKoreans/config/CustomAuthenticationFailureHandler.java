package com.project.onlyForKoreans.config;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        System.out.println("exception:" + exception);
        System.out.println("request:" + request);
        System.out.println("response:" + response);

        String errorMessage = null;

        if(exception instanceof BadCredentialsException || exception instanceof InternalAuthenticationServiceException)
            errorMessage = "아이디 또는 비밀번호가 맞지 않습니다.";
        if(exception instanceof UsernameNotFoundException)
            errorMessage = "존재하지 않는 아이디 입니다.";
        if(exception instanceof AuthenticationCredentialsNotFoundException)
            errorMessage = "알 수 없는 오류로 로그인 요청을 처리할 수 없습니다. 관리자에게 문의하세요.";

        System.out.println("errorMessage:"+errorMessage);

        errorMessage = URLEncoder.encode(errorMessage, "UTF-8");
        setDefaultFailureUrl("/auth/loginForm?error=true&exception=" + errorMessage);
        super.onAuthenticationFailure(request, response, exception);
    }
}
