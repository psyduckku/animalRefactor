package com.refactor.animals.beans.dto;

import lombok.Data;

@Data
public class ReplyParam {

    private int adt_id;
    private int aseq;
    private int reply_id;
    private String login_id;
    private String orderby;
//    private boolean good;
//    private boolean bad;
    private String content;
    private int good_count;
    private int bad_count;
    private String upper_id;

}
