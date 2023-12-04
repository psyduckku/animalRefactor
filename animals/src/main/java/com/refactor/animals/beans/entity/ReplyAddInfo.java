package com.refactor.animals.beans.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReplyAddInfo {
    private int info_id;
    private int reply_id;//
    private String table_name;//
    private int good_status;
    private int bad_status;
    private int report;
    private String regdate;
    private String login_id;//

    /***
     * 댓글 입력
     * @param reply_id
     * @param table_name
     * @param login_id
     */
    public ReplyAddInfo(int reply_id, String table_name, String login_id) {
        this.reply_id = reply_id;
        this.table_name = table_name;
        this.login_id = login_id;
    }

    public ReplyAddInfo(String table_name) {
        this.table_name = table_name;
    }
}
