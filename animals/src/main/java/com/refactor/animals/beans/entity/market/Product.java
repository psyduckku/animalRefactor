package com.refactor.animals.beans.entity.market;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@ToString
public class Product {
    private int product_id;
    private String title;
    private String content;
    private int price;
    private int status;
    private String thumbnail_content;
    private int category_id;
    private String code;
    private String code_name;
    private String up_code;


    private int stock_id;
    private String size;

    private int qty;
    private int store_id;
    private String board;
    private int id;
    private String upload_file_name;
    private String store_file_name;
    private String ext_name;
    private double file_size;

}
