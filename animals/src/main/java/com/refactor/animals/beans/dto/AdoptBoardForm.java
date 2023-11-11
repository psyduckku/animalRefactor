package com.refactor.animals.beans.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdoptBoardForm {
    private String login_id;
    private String title;
    private String content;

    /***
     * 게시판 입력
     */
    AdoptBoardForm(String login_id, String title, String content) {
        this.login_id = login_id;
        this.title = title;
        this.content = content;
    }
}
