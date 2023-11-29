package com.refactor.animals.beans.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdoptReplyBoardVO {
    private int reply_id;
    private int adt_id;
    private String upper_id;
    private String login_id;
    private String content;
    private String regdate;

    ReplyAddInfo replyAddInfo;

    /****
     *  댓글 쓰기
     * @param adt_id
     * @param upper_id
     * @param login_id
     * @param content
     */

    public AdoptReplyBoardVO(int adt_id, String upper_id, String login_id, String content) {
        this.adt_id = adt_id;
        this.upper_id = upper_id;
        this.login_id = login_id;
        this.content = content;
    }
}
