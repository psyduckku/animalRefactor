package com.refactor.animals.beans.entity;

import lombok.Data;

@Data
public class UploadFileVO {

    private int store_id;
    private int adt_id;
    private String upload_file_name;
    private String store_file_name;
    private String ext_name;
    private double file_size;


    /****
     * db저장 생성자
     * @param adt_id
     * @param upload_file_name
     * @param store_file_name
     * @param ext_name
     */

    public UploadFileVO(int adt_id, String upload_file_name, String store_file_name, String ext_name, double file_size) {
        this.adt_id = adt_id;
        this.upload_file_name = upload_file_name;
        this.store_file_name = store_file_name;
        this.ext_name = ext_name;
        this.file_size = file_size;
    }
}
