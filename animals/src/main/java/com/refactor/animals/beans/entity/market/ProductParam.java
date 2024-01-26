package com.refactor.animals.beans.entity.market;

import lombok.*;

@Getter
@ToString
@Builder
@Setter
public class ProductParam {
    private int product_id;
    private String title;
    private String content;
    private int price;
    private int status;
    private int category_id;
    private String code;
    private String code_name;
    private String up_code;
    private int stock_id;
    private String size;
    private int qty;
    private String etc;
    private String thumbnail_img;
    private String thumbnail_content;
    private String store_file_name;
    private int id;

    /***
     * 어드민 상품 상세보기
     * @param product_id
     * @param size
     */
    public ProductParam detailParam(int product_id, String size) {
        this.product_id = product_id;
        this.size = size;
        return this;
    }


    /****
     * 어드민 상품 리스트보기
     * @param title
     * @param status
     * @param category_id
     * @return
     */
    public ProductParam adminProdList(String title, int status, int category_id){
        this.title = title;
        this.status = status;
        this.category_id = category_id;
        return this;
    }

    public ProductParam() {
    }

    public ProductParam(int product_id, String title, String content, int price, int status, int category_id, String code, String code_name, String up_code, int stock_id, String size, int qty, String etc, String thumbnail_img, String thumbnail_content, String store_file_name, int id) {
        this.product_id = product_id;
        this.title = title;
        this.content = content;
        this.price = price;
        this.status = status;
        this.category_id = category_id;
        this.code = code;
        this.code_name = code_name;
        this.up_code = up_code;
        this.stock_id = stock_id;
        this.size = size;
        this.qty = qty;
        this.etc = etc;
        this.thumbnail_img = thumbnail_img;
        this.thumbnail_content = thumbnail_content;
        this.store_file_name = store_file_name;
        this.id = id;
    }
}
