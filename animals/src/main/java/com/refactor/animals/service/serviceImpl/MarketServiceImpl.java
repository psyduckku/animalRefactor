package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.entity.market.Category;
import com.refactor.animals.beans.entity.market.ProductVO;
import com.refactor.animals.repository.MarketRepository;
import com.refactor.animals.service.MarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MarketServiceImpl implements MarketService {

    private final MarketRepository repository;
    @Override
    public List<Category> selectCategoryHierarchy(Category category) {
        return repository.selectCategoryHierarchy(category);
    }

    @Override
    public List<Category> getSubCategory(String up_code) {
        return repository.getSubCategory(up_code);
    }

    @Override
    public int reg_product(ProductVO vo) {
        return repository.reg_product(vo);
    }

    @Override
    public int mod_product(ProductVO vo) {
        return repository.mod_product(vo);
    }

    @Override
    public int del_product(int product_id) {
        return repository.del_product(product_id);
    }

    @Override
    public ProductVO find_product(int product_id) {
        return repository.find_product(product_id);
    }


}
