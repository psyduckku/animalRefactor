package com.refactor.animals.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

//    @GetMapping("/index")
    public String index(){

        return "/bootstrap_admin/index";
    }

    @GetMapping("/index")
    public String index2(){

        return "/adminBoard/index";
    }

    @GetMapping("/sideMenu")
    public String sideMenu(){
        return "sideMenu";
    }
}
