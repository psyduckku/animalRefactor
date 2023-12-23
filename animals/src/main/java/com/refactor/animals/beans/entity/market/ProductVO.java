package com.refactor.animals.beans.entity.market;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
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
    int category_id;
}
