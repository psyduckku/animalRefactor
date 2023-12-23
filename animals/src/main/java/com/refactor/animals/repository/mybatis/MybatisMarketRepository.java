package com.refactor.animals.repository.mybatis;

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
    public int reg_product(ProductVO vo) {
        return marketMapper.reg_product(vo);
    }

    @Override
    public int mod_product(ProductVO vo) {
        return marketMapper.mod_product(vo);
    }

    @Override
    public int del_product(int product_id) {
        return marketMapper.del_product(product_id);
    }

    @Override
    public ProductVO find_product(int product_id) {
        return marketMapper.find_product(product_id);
    }
}
