package com.refactor.animals.repository;

import com.refactor.animals.beans.entity.ThumbnailVO;
import com.refactor.animals.beans.entity.UploadFileVO;

import java.util.List;

public interface UploadFileRepository{

    int insertFiles(List<UploadFileVO> vo);
    List<UploadFileVO> getFiles(int adt_id);
    UploadFileVO downloadImage(int store_id);
    ThumbnailVO getThumbnail(int adt_id);
    int deleteFile(int adt_id);
}
