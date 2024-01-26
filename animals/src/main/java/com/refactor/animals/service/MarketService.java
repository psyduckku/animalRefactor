package com.refactor.animals.service;

import com.refactor.animals.beans.dto.market.AdminProdListParam;
import com.refactor.animals.beans.entity.market.*;

import java.util.List;

public interface MarketService {

    List<Category> selectCategoryHierarchy(Category category);
    List<Category> getSubCategory(String up_code);
    int regProduct(ProductVO vo);
    int modProduct(ProductVO vo);
    ProductVO findProduct(int product_id);
    List<ProductVO> getProductList();
    List<Product> getAdminProdList(AdminProdListParam vo);
    List<ProductVO> getMainProductList(ProductParam vo);
    ProductVO getDetailPage(int product_id);
    int regStock(Stock stock);
    ProductVO getAdminProd(ProductParam vo);
    int deleteProd(ProdStockVO vo);
    int updateProd(ProductVO vo);

    List<Category> getUpperCate(String up_code);
    int updateStock(Stock stock);


}
