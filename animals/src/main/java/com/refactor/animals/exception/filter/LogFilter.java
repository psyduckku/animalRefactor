package com.refactor.animals.exception.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.UUID;

@Slf4j
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("log filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("log filter do filter ");
        HttpServletRequest httpRequest= (HttpServletRequest) request;//부모 request는 기능이 별로 없어서 다운캐스팅해야함
        String requestURI = httpRequest.getRequestURI();

        String uuid = UUID.randomUUID().toString(); //uuid를 남기는이유: transaction id(고객 요청id를 남기는것)
        //시간이 오래걸릴경우 시간도 request/response에 남기면 확인가능
        try{
            log.info("REQUEST [{}][{}][{}]", uuid, request.getDispatcherType(), requestURI);
            chain.doFilter(request, response); //다음필터 호출
        }catch(Exception e){
            throw e;
        }finally{
            log.info("RESPONSE [{}][{}][{}]", uuid, request.getDispatcherType(), requestURI);
        }

        //이후 등록 필요


    }

    @Override
    public void destroy() {
        log.info("log filter destroy");
        Filter.super.destroy();
    }
}
