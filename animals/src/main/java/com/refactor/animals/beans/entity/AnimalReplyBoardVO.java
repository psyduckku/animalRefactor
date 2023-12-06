package com.refactor.animals.beans.entity;

import lombok.Data;

@Data
public class AnimalReplyBoardVO {

    private int reply_id;
    private int aseq;
    private String upper_id;
    private String login_id;
    private String content;
    private int good_count;
    private int bad_count;
    private boolean best_reply;
    private String regdate;
    private boolean report_status;

    ReplyAddInfo replyAddInfo;



}
