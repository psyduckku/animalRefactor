package com.refactor.animals.beans.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class AdoptBoardVO {

    private int adt_id;
    private String login_id;
    private String regdate;
    private String title;
    private String content;

//    private MultipartFile attach_file;
    private List<MultipartFile> image_files;

    private int cnt;
    private boolean flag;

    /***
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
