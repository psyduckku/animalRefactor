package com.refactor.animals.controller;

import com.refactor.animals.beans.entity.market.Category;
import com.refactor.animals.service.MarketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/adminBoard")
public class AdminController {

    private final MarketService marketService;

//    @GetMapping("/index")
    public String index(){
        return "/bootstrap_admin/index";
    }

    @GetMapping("/index")
    public String index2(){
        return "/adminBoard/index";
    }

    @GetMapping("/members")
    public String members(){
        return "/adminBoard/members";
    }

    @GetMapping("/animals")
    public String animals(){
        return "/adminBoard/animals";
    }

    @GetMapping("/products")
    public String products(){
        return "/adminBoard/products";
    }




}
