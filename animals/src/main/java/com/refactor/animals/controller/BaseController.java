package com.refactor.animals.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/base")
public class BaseController {

    @GetMapping("/")
    public String index(){
        log.info("index접근");
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(){
        log.info("login접근");
        return "login";
    }

    @PostMapping("/login")
    public String login(){

        return "/";
    }

    @GetMapping("/join")
    public String join(){
        log.info("join접근");
        return "join";
    }



}
