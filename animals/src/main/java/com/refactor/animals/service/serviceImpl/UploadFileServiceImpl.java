package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.entity.ThumbnailVO;
import com.refactor.animals.beans.entity.UploadFileVO;
import com.refactor.animals.repository.UploadFileRepository;
import com.refactor.animals.service.UploadFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UploadFileServiceImpl implements UploadFileService {
    private final UploadFileRepository repository;

    @Override
    public int insertFiles(List<UploadFileVO> vo) {
      log.info("vo={}",vo.toString());
        return repository.insertFiles(vo);
    }

    @Override
    public List<UploadFileVO> getFiles(int adt_id) {
        return repository.getFiles(adt_id);
    }

    @Override
    public UploadFileVO downloadImage(int store_id) {
        return repository.downloadImage(store_id);
    }

    @Override
    public ThumbnailVO getThumbnail(int adt_id) {
        return repository.getThumbnail(adt_id);
    }
}
