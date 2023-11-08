package com.refactor.animals.common.interceptor;

import com.refactor.animals.common.KeyCollection;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        String uuid = UUID.randomUUID().toString();

        log.info("requestURI={}", requestURI);
        HttpSession session = request.getSession();
        if(session==null || session.getAttribute(KeyCollection.LOGIN_ID) == null){
            log.info("미인증 사용자 요청");
            response.sendRedirect("/base/login");
            return false;
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
