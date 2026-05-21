package com.ohgiraffers.security.auth.handler;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
/*******************************************
 📖 개념: 인증 실패(401)와 인가 실패(403)의 처리 전략
 ********************************************/

// G1) filter 에서 발생할 수 있는 예외들을 해당 클래스의 handler 에서 처리
//    RestControllerAdvice 에서 절대 잡을 수 없음
//    반드시 구현 할 것!!
//    error 발생 위치에 따라 처리할 수 있는 예외의 종류 및 클래스가 다름!, 예외 발생 위치가 가장 중요함

/*
✅ AccessDeniedHandler
- 인증은 되었지만 권한이 부족한 경우 호출됨
- ex) ROLE_USER 가 ROLE_ADMIN 자원에 접근한 경우
- 응답 코드: 403 Forbidden
*/

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    /*
     * 인가 실패 처리
     * ex) ROLE_USER 가 관리자 페이지에 접근
     */
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {

        response.setStatus(HttpServletResponse.SC_FORBIDDEN); // 403
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write("{ \"error\": \"접근 권한이 없습니다.\" }");
    }
}