package com.refactor.animals.beans.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdoptBoardVO {
    private int adt_id;
    private String login_id;
    private String regdate;
    private String title;
    private String content;
    private List<MultipartFile> image_files;
    private int cnt;
    private boolean bookmark;
    private int count;
//    private String thumbnail;


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

    /***
     * 게시물 수정
     * @param adt_id
     * @param title
     * @param content
     */
    public AdoptBoardVO(int adt_id, String title, String content) {
        this.adt_id = adt_id;
        this.title = title;
        this.content = content;
    }

    

}
