package com.refactor.animals.beans.dto.market;

import lombok.*;

@Setter
@Getter
@ToString
public class AdminProdListParam {

    private int status;
    private int category_id;
    private String title;

    public AdminProdListParam() {
    }

    public AdminProdListParam(int status, int category_id, String title) {
        this.status = status;
        this.category_id = category_id;
        this.title = title;
    }
}
