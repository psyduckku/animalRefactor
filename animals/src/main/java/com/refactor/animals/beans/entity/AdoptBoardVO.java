package com.refactor.animals.beans.entity;

import lombok.Data;

@Data
public class AdoptBoardVO {

    private int adt_id;
    private String login_id;
    private String regdate;
    private String title;
    private String content;
    private int cnt;
    private boolean flag;

    /**
     * 게시물 등록
     * @param login_id
     * @param title
     * @param content
     */
    public AdoptBoardVO(String login_id, String title, String content) {

        this.login_id = login_id;
        this.title = title;
        this.content = content;
    }
}
