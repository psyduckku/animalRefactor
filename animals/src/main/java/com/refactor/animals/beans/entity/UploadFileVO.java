package com.refactor.animals.beans.entity;

import lombok.*;

@Setter@Getter
@ToString
public class UploadFileVO {

    private int store_id;
    private String board;
    private int id;
    private String upload_file_name;
    private String store_file_name;
    private String ext_name;
    private double file_size;

    public UploadFileVO() {
    }

    public UploadFileVO(String board, int id, String upload_file_name, String store_file_name, String ext_name, double file_size) {
        this.board = board;
        this.id = id;
        this.upload_file_name = upload_file_name;
        this.store_file_name = store_file_name;
        this.ext_name = ext_name;
        this.file_size = file_size;
    }
    //게시글 찾기 id, 보드명

    public UploadFileVO(String board, int id) {
        this.board = board;
        this.id = id;
    }

    public UploadFileVO(int store_id, String board, int id, String upload_file_name, String store_file_name, String ext_name, double file_size) {
        this.store_id = store_id;
        this.board = board;
        this.id = id;
        this.upload_file_name = upload_file_name;
        this.store_file_name = store_file_name;
        this.ext_name = ext_name;
        this.file_size = file_size;
    }
}
