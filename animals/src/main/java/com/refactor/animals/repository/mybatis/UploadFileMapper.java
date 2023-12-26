package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.entity.ThumbnailVO;
import com.refactor.animals.beans.entity.UploadFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UploadFileMapper {

    int insertFiles(List<UploadFileVO> vo);
    List<UploadFileVO> getFiles(UploadFileVO vo);
    UploadFileVO downloadImage(int store_id);
    ThumbnailVO getThumbnail(UploadFileVO vo);
    int deleteFile(UploadFileVO vo);
}
