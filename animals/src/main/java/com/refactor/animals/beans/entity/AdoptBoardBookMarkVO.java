package com.refactor.animals.beans.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class AdoptBoardBookMarkVO {

    private int adt_id;
    private String title;
    private String content;
    private String login_id;
    private String store_file_name;
    private String regdate;

}
