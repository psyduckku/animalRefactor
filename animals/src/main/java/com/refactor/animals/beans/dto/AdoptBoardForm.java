package com.refactor.animals.beans.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AdoptBoardForm {
    private String login_id;
    private String title;
    private String content;

//    private MultipartFile attach_file;
    private List<MultipartFile> image_files;

    /***
     * 게시판 입력
     */
    AdoptBoardForm(String login_id, String title, String content, List<MultipartFile> image_files) {
        this.login_id = login_id;
        this.title = title;
        this.content = content;
        this.image_files = image_files;
    }

    public AdoptBoardForm(String login_id, String title, String content) {
        this.login_id = login_id;
        this.title = title;
        this.content = content;
    }
}
