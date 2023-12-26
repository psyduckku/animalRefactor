package com.refactor.animals.controller;

import com.refactor.animals.beans.entity.market.AdminProdVoList;
import com.refactor.animals.beans.entity.market.Category;
import com.refactor.animals.service.MarketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/market")
public class MarketController {

    private final MarketService marketService;

    @GetMapping("/")
    public String index(){

        return "/marketBoard/index";
    }

    @GetMapping("/regProduct")
    public String regProduct(){


        return "/marketBoard/regProduct";
    }

    @ResponseBody
    @GetMapping("/getCateList")
    public List<Category> categories(Category category){
        List<Category> list = marketService.selectCategoryHierarchy(category);
        return list;
    }
    @ResponseBody
    @GetMapping("/getSubCategory/{category}")
    public List<Category> getSubCategory(@PathVariable String category){
        List<Category> list = marketService.getSubCategory(category);
        log.info("list={}",list);
        return list;
    }

    @ResponseBody
    @GetMapping("/getMainProdList")
    public List<AdminProdVoList> getMainProdList(AdminProdVoList vo){
        List<AdminProdVoList> list = marketService.getAdminProdList(vo);

        return list;
    }
}
