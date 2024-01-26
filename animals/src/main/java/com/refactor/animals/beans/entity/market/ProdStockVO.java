package com.refactor.animals.beans.entity.market;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter
@ToString
@NoArgsConstructor
public class ProdStockVO {
    int product_id;
    int stock_id;
    String size;

    public ProdStockVO(int product_id, String size) {
        this.product_id = product_id;
        this.size = size;
    }
}
