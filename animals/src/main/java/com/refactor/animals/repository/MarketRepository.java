package com.refactor.animals.repository;

import com.refactor.animals.beans.entity.market.Category;
import com.refactor.animals.beans.entity.market.ProductVO;

import java.util.List;

public interface MarketRepository {
    List<Category> selectCategoryHierarchy(Category category);

    List<Category> getSubCategory(String up_code);
    int reg_product(ProductVO vo);
    int mod_product(ProductVO vo);
    int del_product(int product_id);
    ProductVO find_product(int product_id);
}
