package com.refactor.animals.controller;

import com.refactor.animals.beans.entity.market.Category;
import com.refactor.animals.beans.entity.market.ProductParam;
import com.refactor.animals.beans.entity.market.ProductVO;
import com.refactor.animals.service.MarketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public List<ProductVO> getMainProdList(ProductParam vo){
        List<ProductVO> list = marketService.getMainProductList(vo);

        return list;
    }

    @GetMapping("/detailPage/{product_id}")
    public String detailPage(@PathVariable int product_id, Model model){
        ProductVO product = marketService.getDetailPage(product_id);
        log.info("product={}",product);
//        log.info("product.size()={}",product.size());
        model.addAttribute("product", product);

        return "/marketBoard/detailPage";
    }

    @GetMapping("/orderForm")
    public String payment(){

        return "/marketBoard/orderForm";
    }

    @ResponseBody
    @PostMapping("/cate/upCode")
    public List<Category> getUpcode(@RequestBody String up_code){
        List<Category> category = marketService.getUpperCate(up_code);

        return category;
    }

}
