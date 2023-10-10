package com.refactor.animals.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class ErrorPageController {
    @RequestMapping("/error-ex")
    public void errorPage500(){
        throw new RuntimeException("예외발생");
    }
}
