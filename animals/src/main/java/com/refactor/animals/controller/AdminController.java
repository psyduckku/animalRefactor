package com.refactor.animals.controller;

import com.refactor.animals.beans.entity.FileStore;
import com.refactor.animals.beans.entity.UploadFileVO;
import com.refactor.animals.beans.entity.market.AdminProdVoList;
import com.refactor.animals.beans.entity.market.ProductVO;
import com.refactor.animals.service.MarketService;
import com.refactor.animals.service.UploadFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/adminBoard")
public class AdminController {

    private final MarketService marketService;
    private final FileStore fileStore;
    private final UploadFileService uploadFileService;

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
    public String products(Model model){

        return "/adminBoard/products";
    }

    @ResponseBody
    @GetMapping("/getProductList")
    public List<AdminProdVoList> getProductList(AdminProdVoList vo){
        List<AdminProdVoList> list = marketService.getAdminProdList(vo);
        log.info("list={}", list);

        return list;
    }
    @ResponseBody
    @GetMapping("/getAdminProdList")
    public List<AdminProdVoList> getAdminProdList(AdminProdVoList vo){
        List<AdminProdVoList> list = marketService.getAdminProdList(vo);
        log.info("list={}", list);
        return list;
    }


    @ResponseBody
    @PostMapping(value = "/regProduct", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public int regProduct(@RequestPart ProductVO productVO,
                          @RequestPart(value="file", required=false)List<MultipartFile> file) throws IOException {
        log.info("productVO={}", productVO);


        int id = marketService.regProduct(productVO);
        log.info("상품등록으로 반환된 id={}",id);
        if(file!=null){
            log.info("file={}", file);
            List<UploadFileVO> storeFileList = fileStore.storeFiles(file, "product", id);
            int row = uploadFileService.insertFiles(storeFileList);
        }
        //jackson2HttpMessageConverter에 의해 body에 json으로 변환해줌
        //Spring은 Http응답 Content-Type을 application/json으로 설정됨
        return 1;
    }

    @ResponseBody
    @PostMapping("/delProduct")
    public ResponseEntity<Integer> delProudct(@RequestBody int[] product_ids){
        log.info("product_ids={}",product_ids);
        Integer result =0;
        for(int p : product_ids){
            result += marketService.delProduct(p);
        }

        return ResponseEntity.ok(result);
    }
//    @GetMapping()

//    @GetMapping("/productList")
//    public List<ProductVO> productList(){
//
//    }


//    @GetMapping("/getProduct/{}")
//    public ProductVO getProduct(){
//
//    }




}
