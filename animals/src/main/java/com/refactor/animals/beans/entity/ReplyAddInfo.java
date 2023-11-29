package com.refactor.animals.beans.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReplyAddInfo {
    private int his_id;
    private int reply_id;
    private String table_name;
    private int good;
    private int bad;
    private int report_count;

}
