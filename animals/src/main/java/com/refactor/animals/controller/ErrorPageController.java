package com.refactor.animals.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class ErrorPageController {

//    public static final String ERROR_EXCEPTION = "jakarta.servlet.error.exception";
//    public static final String ERROR_EXCEPTION_TYPE = "jakarta.servlet.error.exception_type";
//    public static final String ERROR_MESSAGE = "jakarta.servlet.error.message";
//    public static final String ERROR_REQUEST_URI = "jakarta.servlet.error.request_uri";
//    public static final String ERROR_SERVLET_NAME = "jakarta.servlet.error.servlet_name";
//    public static final String ERROR_STATUS_CODE = "jakarta.servlet.error.status_code";

    @RequestMapping("/error-page/404")
    public String errorPage404(HttpServletRequest request, HttpServletResponse
            response) {
        log.info("errorPage 404");


        return "error-page/404";
    }
    @RequestMapping("/error-page/500")
    public String errorPage500(HttpServletRequest request, HttpServletResponse
            response) {
        log.info("errorPage 500");
        return "error-page/500";
    }

    //JSON에 대한 exception response를 위한 용도
    @RequestMapping(value = "/error-page/500",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> errorPage500Api(HttpServletRequest request, HttpServletResponse response){
        log.info("API errorPage 500");
        Map<String, Object> result = new HashMap<>();

        Exception ex = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);//메세지 꺼내는용도

        result.put("status", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));//상태코드반환
        result.put("message", ex.getMessage()); //메시지 반환

        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        return new ResponseEntity(result, HttpStatus.valueOf(statusCode));
    }
}
