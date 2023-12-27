package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.entity.market.AdminProdVoList;
import com.refactor.animals.beans.entity.market.Category;
import com.refactor.animals.beans.entity.market.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MarketMapper {
    List<Category> selectCategoryHierarchy(Category category);
    List<Category> getSubCategory(String up_code);
    int regProduct(ProductVO vo);
    int modProduct(ProductVO vo);
    int delProduct(int product_id);
    ProductVO findProduct(int product_id);
    List<ProductVO> getProductList();

    List<AdminProdVoList> getAdminProdList(AdminProdVoList vo);
    List<AdminProdVoList> getMainProductList(AdminProdVoList vo);
    List<ProductVO> getDetailPage(int product_id);

}
