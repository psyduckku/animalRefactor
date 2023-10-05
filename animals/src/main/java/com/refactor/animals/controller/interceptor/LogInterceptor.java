package com.refactor.animals.controller.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    public static final String LOG_ID = "logId";

    // interceptor는 싱글톤으로 만들어졌기 때문에 필드변수로 uuid를 생성하면 안됨?
    //싱글톤은 한개의 instance가 여러 요청을 처리하는데, uuid변수를 공유해서 사용하는 필드변수로 사용하면 여러 요청에서 해당 변수를
    // 동시에 수정할 수 있어서 문제가 생긴다고함. (동시성문제)
    // UUID는 싱글톤 객체로 interceptor가 작동할때마다 새로운 uuid를 상수에 넘겨줌.
    // 이는 prehandle자체가 메서드를 사용할때마다 새로운 상수를 넘겨주기 때문에 문제가 되지않나?
    @Override //preHandle에서는 정상적인처리가 될때 무언가 후처리를 하고 싶을때 사용. view모델 전달전 model에 추가데이터 담을수도있음
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //handler가 Object인 이유는 handler adaptor가 처리해주기 때문에 Object임
        String requestURI = request.getRequestURI();
        String uuid = UUID.randomUUID().toString();
        request.setAttribute(LOG_ID, uuid); //상수로빼기 ctrl+alt+c

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        request.getAttribute(LOG_ID);

    }
}
