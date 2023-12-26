package com.refactor.animals.service;

import com.refactor.animals.beans.entity.ThumbnailVO;
import com.refactor.animals.beans.entity.UploadFileVO;

import java.util.List;

public interface UploadFileService {

    int insertFiles(List<UploadFileVO> vo);
    List<UploadFileVO> getFiles(UploadFileVO vo);
    UploadFileVO downloadImage(int store_id);
    ThumbnailVO getThumbnail(UploadFileVO vo);
    int deleteFile(UploadFileVO vo);
}
