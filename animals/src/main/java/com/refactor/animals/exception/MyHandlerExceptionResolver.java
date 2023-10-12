package com.refactor.animals.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        log.info("call resolver", ex);
        //IllegalArgumentException이 아닐경우 null을 던지기 때문에 WAS에서 500에러를 발생시킴
        try {
            if(ex instanceof IllegalArgumentException) { //예외타입일치확인
                log.info("IllegalArgumentException resolver to 400");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
                return new ModelAndView(); //비어있는 MV를 반환(뷰렌더링x)
                //MV를 채워서 뷰페이지를 렌더링해서 제공하거나, API응답처리를 함
            }
        } catch (IOException e) {
            log.error("resolver ex", e); //에러는 ={}이렇게 할필요 없음
        }

        return null;
    }
}
