package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.entity.market.AdminProdVoList;
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
    public int regProduct(ProductVO vo) {
        repository.regProduct(vo);
        return vo.getProduct_id();
    }

    @Override
    public int modProduct(ProductVO vo) {
        return repository.modProduct(vo);
    }

    @Override
    public int delProduct(int product_id) {
        return repository.delProduct(product_id);
    }

    @Override
    public ProductVO findProduct(int product_id) {
        return repository.findProduct(product_id);
    }

    @Override
    public List<ProductVO> getProductList() {
        return repository.getProductList();
    }

    @Override
    public List<AdminProdVoList> getAdminProdList(AdminProdVoList vo) {
        return repository.getAdminProdList(vo);
    }

    @Override
    public List<AdminProdVoList> getMainProductList(AdminProdVoList vo) {
        return repository.getMainProductList(vo);
    }

    @Override
    public List<ProductVO> getDetailPage(int product_id) {
        return repository.getDetailPage(product_id);
    }


}
