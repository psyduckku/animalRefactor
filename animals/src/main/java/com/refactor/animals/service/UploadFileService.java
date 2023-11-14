package com.refactor.animals.service;

import com.refactor.animals.beans.entity.UploadFileVO;

import java.util.List;

public interface UploadFileService {

    int insertFiles(List<UploadFileVO> vo);
    List<UploadFileVO> getFiles(int adt_id);
    UploadFileVO downloadImage(int store_id);

}
