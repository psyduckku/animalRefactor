package com.refactor.animals.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    public static final String LOG_ID = "logId";

    @Override //preHandle에서는 정상적인처리가 될때 무언가 후처리를 하고 싶을때 사용. view모델 전달전 model에 추가데이터 담을수도있음
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //handler가 Object인 이유는 handler adaptor가 처리해주기 때문에 Object임

        String requestURI = request.getRequestURI();
        String uuid = UUID.randomUUID().toString();
        request.setAttribute(LOG_ID, uuid); //상수로빼기 ctrl+alt+c
        //afterCompletion인 종료까지 동일한 아이디를 보내줘야함. filter와는 다르게 다른 메서드에 있기 때문에 넘겨줘야함.

        if(handler instanceof HandlerMethod){ //handler가 HandlerMethod의 인스턴스인지 확인
            HandlerMethod hm = (HandlerMethod) handler; //그리고 해당 타입으로 변환. 즉, 핸들러는 다형성을 위해 Object인데,
        }                                               //사용할때는 해당 타입으로 변경해줘야하니까..?

        log.info("REQUEST [{}][{}][{}][{}]", uuid,request.getDispatcherType(), requestURI, handler);
        //하나 요청에 종료까지 식별하기위한 uuid, 어떤것을 요청하였는지 확인하는 requestURI, 어떤 컨트롤러가 사용되었는지 확인하는 handler
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandler[{}]",modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String uuid = (String) request.getAttribute(LOG_ID);
        String requestURI = request.getRequestURI();
        log.info("[{}][{}][{}]", uuid, requestURI, handler);
        if(ex!=null){
           log.info("afterCompletion ERROR!!", ex);
        }

    }
}
