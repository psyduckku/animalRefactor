package com.refactor.animals.beans.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReplyAddInfoParam {
    private int adt_id;
    private String login_id;

    private int reply_id;
    private List<Integer> reply_id_arr;

}
