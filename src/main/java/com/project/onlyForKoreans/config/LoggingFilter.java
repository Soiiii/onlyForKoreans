package com.project.onlyForKoreans.config;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 필터 초기화 작업 (필요 없으면 비워둬도 됨)
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 요청 전 처리
        System.out.println("Request URI: " + request.getScheme() + "://" + request.getServerName());
        System.out.println("request:" +request);
        System.out.println("Request Parameters: " + request.getParameterMap());

        chain.doFilter(request, response); // 다음 필터 또는 서블릿으로 요청 전달

        // 응답 후 처리 (필요 없으면 비워둬도 됨)
    }

    @Override
    public void destroy() {
        // 필터 해제 작업 (필요 없으면 비워둬도 됨)
    }
}