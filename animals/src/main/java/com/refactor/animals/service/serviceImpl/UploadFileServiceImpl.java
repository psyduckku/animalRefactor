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
        log.info(" 업로드파일 서비스 임플리스트 vo={}",vo);
        return repository.insertFiles(vo);
    }

    @Override
    public List<UploadFileVO> getFiles(UploadFileVO vo) {
        return repository.getFiles(vo);
    }

    @Override
    public UploadFileVO downloadImage(int store_id) {
        return repository.downloadImage(store_id);
    }

    @Override
    public ThumbnailVO getThumbnail(UploadFileVO vo) {
        return repository.getThumbnail(vo);
    }

    @Override
    public int deleteFile(UploadFileVO vo) {
        return repository.deleteFile(vo);
    }
}
