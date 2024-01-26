package com.refactor.animals.beans.entity.market;


import lombok.*;

@Setter@Getter
@ToString
public class Stock {
    private int stock_id;
    private String size;
    private int qty;
    private int product_id;

    public Stock() {
    }

    public Stock(int stock_id, String size, int qty, int product_id) {
        this.stock_id = stock_id;
        this.size = size;
        this.qty = qty;
        this.product_id = product_id;
    }
}
