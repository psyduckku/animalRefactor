package com.refactor.animals.beans.entity.market;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductVO {

    int product_id;
    String title;
    String content;
    int price;
    int stock;
    int status;
    String img1;
    String img2;
    String img3;
    String img4;
    String img5;
    String thumbnail_img;
    String thumbnail_content;
    int major_cate;
    int sub_cate;
    int category_id;
}
