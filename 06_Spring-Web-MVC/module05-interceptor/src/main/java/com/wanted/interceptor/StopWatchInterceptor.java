package com.wanted.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
* comment.
*  Interceptor 를 구현하기 위해서는 HandlerInterceptor 를 상속받아야 한다.
*  해당 클래스는 Interceptor 로 등록이 되며, 컨트롤러의 실핼 전/후 를 가로챌 수 있는
*  권한을 가지게 된다.
* */

@Component
public class StopWatchInterceptor implements HandlerInterceptor {

    /*
    * comment.
    *  preHandle 전처리
    *  컨트롤러의 핸들러메소드가 동작하기 전에 호출된다.
    * */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandle 메소드 호출됨");
        long startTime = System.currentTimeMillis();

        request.setAttribute("startTime", startTime);

        // true : Controller 의 핸들러메소드를 이어서 호출한다.
        // false : Controller 의 핸들러메소드를 호출하지 않는다.
        return true;

    }

     /*
     * comment.
     *  PostHandle 후처리
     *  컨트롤러의 핸들러메소드가 동작한 후에 호출된다.
     * */

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("postHandler 호출됨");

        // int (0) - Integer (null)

        long startTime = (long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();

        // interval = endTime - startTime
        modelAndView.addObject("interval", endTime - startTime);

    }
}
