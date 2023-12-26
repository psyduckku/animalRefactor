package com.refactor.animals.beans.entity.market;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@NoArgsConstructor
@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminProdVoList {
    private int product_id;
    private String title;
    private String content;
    private int price;
    private int stock;
    private int status;
    private String img1;
    private String thumbnail_img;
    private String thumbnail_content;
    private int major_cate;
    private int sub_cate;
    private int category_id;
    private String code_name;
    private String store_file_name;
    private int id;
}
