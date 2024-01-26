package com.refactor.animals.beans.entity.market;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Category {

    private int category_id;
    private String code;
    private String code_name;
    private String up_code;
    private List<Category> children;



}
