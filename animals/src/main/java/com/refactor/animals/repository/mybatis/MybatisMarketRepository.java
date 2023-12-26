package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.entity.market.AdminProdVoList;
import com.refactor.animals.beans.entity.market.Category;
import com.refactor.animals.beans.entity.market.ProductVO;
import com.refactor.animals.repository.MarketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class MybatisMarketRepository implements MarketRepository {

    private final MarketMapper marketMapper;

    @Override
    public List<Category> selectCategoryHierarchy(Category category) {
        return marketMapper.selectCategoryHierarchy(category);
    }

    @Override
    public List<Category> getSubCategory(String up_code) {
        return marketMapper.getSubCategory(up_code);
    }

    @Override
    public int regProduct(ProductVO vo) {
        return marketMapper.regProduct(vo);
    }

    @Override
    public int modProduct(ProductVO vo) {
        return marketMapper.modProduct(vo);
    }

    @Override
    public int delProduct(int product_id) {
        return marketMapper.delProduct(product_id);
    }

    @Override
    public ProductVO findProduct(int product_id) {
        return marketMapper.findProduct(product_id);
    }

    @Override
    public List<ProductVO> getProductList() {
        return marketMapper.getProductList();
    }

    @Override
    public List<AdminProdVoList> getAdminProdList(AdminProdVoList vo) {
        return marketMapper.getAdminProdList(vo);
    }

    @Override
    public List<AdminProdVoList> getMainProductList(AdminProdVoList vo) {
        return marketMapper.getMainProductList(vo);
    }


}
