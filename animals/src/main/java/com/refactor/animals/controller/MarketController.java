package com.refactor.animals.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/marketBoard")
public class MarketController {

    @GetMapping("/index")
    public String index(){

        return "/marketBoard/index";
    }
}
