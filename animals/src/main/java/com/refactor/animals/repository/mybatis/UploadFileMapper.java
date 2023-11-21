package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.entity.ThumbnailVO;
import com.refactor.animals.beans.entity.UploadFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UploadFileMapper {

    int insertFiles(List<UploadFileVO> vo);
    List<UploadFileVO> getFiles(int adt_id);
    UploadFileVO downloadImage(int store_id);
    ThumbnailVO getThumbnail(int adt_id);
    int deleteFile(int adt_id);
}
