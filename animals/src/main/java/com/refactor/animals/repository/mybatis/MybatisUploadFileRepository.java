package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.entity.ThumbnailVO;
import com.refactor.animals.beans.entity.UploadFileVO;
import com.refactor.animals.repository.UploadFileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Repository
public class MybatisUploadFileRepository implements UploadFileRepository {

    private final UploadFileMapper mapper;
    @Override
    public int insertFiles(List<UploadFileVO> vo) {
      log.info("insertFileRepo vo={}", vo.toString());
        return mapper.insertFiles(vo);
    }

    @Override
    public List<UploadFileVO> getFiles(int adt_id) {
        return mapper.getFiles(adt_id);
    }

    @Override
    public UploadFileVO downloadImage(int store_id) {
        return mapper.downloadImage(store_id);
    }

    @Override
    public ThumbnailVO getThumbnail(int adt_id) {
        return mapper.getThumbnail(adt_id);
    }
}
