package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.dto.ReplyAddInfoParam;
import com.refactor.animals.beans.entity.ReplyAddInfo;
import com.refactor.animals.repository.ReplyAddInfoRepository;
import com.refactor.animals.service.ReplyAddInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class ReplyAddInfoServiceImpl implements ReplyAddInfoService {

    private final ReplyAddInfoRepository repository;
    @Override
    public int addGood(ReplyAddInfo replyAddInfo) {
        return repository.addGood(replyAddInfo);
    }

    @Override
    public int addBad(ReplyAddInfo replyAddInfo) {
        return repository.addBad(replyAddInfo);
    }

    @Override
    public int minGood(ReplyAddInfo replyAddInfo) {
        return repository.minGood(replyAddInfo);
    }

    @Override
    public int minBad(ReplyAddInfo replyAddInfo) {
        return repository.minBad(replyAddInfo);
    }

    @Override
    public ReplyAddInfo getReplyAddInfo(ReplyAddInfoParam param) {
        return repository.getReplyAddInfo(param);
    }
}
