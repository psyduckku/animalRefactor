package com.refactor.animals.beans.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReplyAddInfo {
    private int info_id;
    private int reply_id;
    private String table_name;
    private int good_status;
    private int bad_status;
    private int report;
    private String regdate;

}
