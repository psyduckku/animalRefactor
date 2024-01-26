package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.dto.market.AdminProdListParam;
import com.refactor.animals.beans.entity.market.*;
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
    public ProductVO findProduct(int product_id) {
        return repository.findProduct(product_id);
    }

    @Override
    public List<ProductVO> getProductList() {
        return repository.getProductList();
    }

    @Override
    public List<Product> getAdminProdList(AdminProdListParam vo) {
        return repository.getAdminProdList(vo);
    }

    @Override
    public List<ProductVO> getMainProductList(ProductParam vo) {
        return repository.getMainProductList(vo);
    }

    @Override
    public ProductVO getDetailPage(int product_id) {
        return repository.getDetailPage(product_id);
    }

    @Override
    public int regStock(Stock stock) {
        return repository.regStock(stock);
    }

    @Override
    public ProductVO getAdminProd(ProductParam vo) {
        return repository.getAdminProd(vo);
    }

    @Override
    public int deleteProd(ProdStockVO vo) {
        return repository.deleteProd(vo);
    }

    @Override
    public int updateProd(ProductVO vo) {
        return repository.updateProd(vo);
    }

    @Override
    public List<Category> getUpperCate(String up_code) {
        return repository.getUpperCate(up_code);
    }

    @Override
    public int updateStock(Stock stock) {
        return repository.updateStock(stock);
    }


}
