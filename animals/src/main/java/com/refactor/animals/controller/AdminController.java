package com.refactor.animals.controller;

import com.refactor.animals.beans.dto.market.AdminProdListParam;
import com.refactor.animals.beans.entity.FileStore;
import com.refactor.animals.beans.entity.UploadFileVO;
import com.refactor.animals.beans.entity.market.ProdStockVO;
import com.refactor.animals.beans.entity.market.Product;
import com.refactor.animals.beans.entity.market.ProductParam;
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
    public List<Product> getProductList(AdminProdListParam vo){
        List<Product> list = marketService.getAdminProdList(vo);
        log.info("list={}", list);

        return list;
    }
    @ResponseBody
    @GetMapping("/getAdminProdList")
    public List<Product> getAdminProdList(AdminProdListParam vo){
//        ProductParam param = ProductParam.builder().build();
        log.info("11");
//        param.adminProdList(vo.getTitle(), vo.getStatus(), vo.getCategory_id());
        log.info("vo={}", vo);
        List<Product> list = marketService.getAdminProdList(vo);
        log.info("22");
        log.info("list={}", list);
        return list;
    }


    @ResponseBody
    @PostMapping(value = "/regProduct", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public int regProduct(@RequestPart ProductVO productVO,
                          @RequestPart(value="file", required=false)List<MultipartFile> file) throws IOException {
        log.info("productVO={}", productVO);
//        return productVO;
        int product_id = marketService.regProduct(productVO);
        log.info("상품등록으로 반환된 product_id={}",product_id);
        log.info("productVO.getStockArr().size()={}",productVO.getStockArr().size());
        if(productVO.getStockArr().size()>0){
            productVO.getStockArr().stream().forEach(stock->{
                stock.setProduct_id(product_id);
                stock.setSize(stock.getSize());
                stock.setQty(stock.getQty());
                marketService.regStock(stock);
            });
        }

        String board = "product";
        if(file!=null){
            log.info("file={}", file);
            List<UploadFileVO> storeFileList = fileStore.storeFiles(file, board, product_id);
            int row = uploadFileService.insertFiles(storeFileList);
        }
        //jackson2HttpMessageConverter에 의해 body에 json으로 변환해줌
        //Spring은 Http응답 Content-Type을 application/json으로 설정됨
        return 1;
    }

    @ResponseBody
    @PostMapping("/delProduct")
    public ResponseEntity<Integer> delProduct(@RequestBody List<ProdStockVO> product_ids){
        log.info("product_ids={}",product_ids);
        Integer result =0;


        for(ProdStockVO p : product_ids){
            ProdStockVO vo = new ProdStockVO(p.getProduct_id(), p.getSize());
            result += marketService.deleteProd(vo);

        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/detail/{product_id}/{size}")
    public String detail(@PathVariable int product_id, @PathVariable String size, Model model){
        ProductParam param = ProductParam.builder().build();
        param.detailParam(product_id, size);
        ProductVO product = marketService.getAdminProd(param);
        log.info("product={}", product);
        model.addAttribute("product", product);
        return "adminBoard/detail";
    }

    @GetMapping("/updateForm/{product_id}/{size}")
    public String updateForm(@PathVariable int product_id, @PathVariable String size, Model model){
        ProductParam param = ProductParam.builder().build();
        param.detailParam(product_id,size);
        ProductVO product = marketService.getAdminProd(param);
        log.info("product={}", product);
        model.addAttribute("product", product);
        return "adminBoard/updateForm";
    }

    @ResponseBody
    @PostMapping("/delProdImg")
    public int delProdImg(@RequestBody String store_id, UploadFileVO vo){
        int toStrStoreId = Integer.parseInt(store_id);
        String board = "product";
        vo.setStore_id(toStrStoreId);
        vo.setBoard(board);
        int result = uploadFileService.deleteFile(vo);
        log.info("result={}",result);

        return result;
    }

    @ResponseBody
    @PostMapping(value="/updateProd", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public int updateProd(@RequestPart ProductVO productVO,
                          @RequestPart(value="file", required=false)List<MultipartFile> file) throws IOException {
        log.info("productVO={}",productVO);
        log.info("product_id={}", productVO.getProduct_id());
        log.info("file={}", file);
        int row = marketService.updateProd(productVO);
        log.info("row={}", row);
        int product_id = productVO.getProduct_id();
        if(productVO.getStockArr().size()>0){
            productVO.getStockArr().stream().forEach(stock->{
                stock.setProduct_id(product_id);
                stock.setSize(stock.getSize());
                stock.setQty(stock.getQty());
                //이부분 update로 바꿔야
                int updateRow = marketService.updateStock(stock);
                log.info("updateRow={}",updateRow);
            });
        }

        String board="product";
        if(file!=null){
            log.info("file={}",file);
            List<UploadFileVO> storeFileList = fileStore.storeFiles(file,board,product_id);
            uploadFileService.insertFiles(storeFileList);
        }
        return 1;
    }

}
