package com.refactor.animals.beans.entity.market;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.refactor.animals.beans.entity.UploadFileVO;
import lombok.*;

import java.util.List;


@Setter@Getter
@ToString
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@AllArgsConstructor
//@NoArgsConstructor
public class ProductVO {

    private int product_id;
    private String title;
    private String content;
    private int price;
    private int status;
    private String thumbnail_content;
    private String etc;
    private int category_id;
    private String code;
    private String code_name;
    private String up_code;
    private List<UploadFileVO> files;
    private List<Stock> stockArr;

    public ProductVO() {
    }

    public ProductVO(int product_id, String title, String content, int price, int status, String thumbnail_content, String etc, int category_id, String code, String code_name, String up_code, List<UploadFileVO> files, List<Stock> stockArr) {
        this.product_id = product_id;
        this.title = title;
        this.content = content;
        this.price = price;
        this.status = status;
        this.thumbnail_content = thumbnail_content;
        this.etc = etc;
        this.category_id = category_id;
        this.code = code;
        this.code_name = code_name;
        this.up_code = up_code;
        this.files = files;
        this.stockArr = stockArr;
    }
}


