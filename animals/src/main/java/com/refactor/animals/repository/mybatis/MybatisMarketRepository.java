package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.dto.market.AdminProdListParam;
import com.refactor.animals.beans.entity.market.*;
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
    public ProductVO findProduct(int product_id) {
        return marketMapper.findProduct(product_id);
    }

    @Override
    public List<ProductVO> getProductList() {
        return marketMapper.getProductList();
    }

    @Override
    public List<Product> getAdminProdList(AdminProdListParam vo) {
        return marketMapper.getAdminProdList(vo);
    }

    @Override
    public List<ProductVO> getMainProductList(ProductParam vo) {
        return marketMapper.getMainProductList(vo);
    }

    @Override
    public ProductVO getDetailPage(int product_id) {
        return marketMapper.getDetailPage(product_id);
    }

    @Override
    public int regStock(Stock stock) {
        return marketMapper.regStock(stock);
    }

    @Override
    public ProductVO getAdminProd(ProductParam vo) {
        return marketMapper.getAdminProd(vo);
    }

    @Override
    public int deleteProd(ProdStockVO vo) {
        return marketMapper.deleteProd(vo);
    }

    @Override
    public int updateProd(ProductVO vo) {
        return marketMapper.updateProd(vo);
    }

    @Override
    public List<Category> getUpperCate(String up_code) {
        return marketMapper.getUpperCate(up_code);
    }

    @Override
    public int updateStock(Stock stock) {
        return marketMapper.updateStock(stock);
    }


}
