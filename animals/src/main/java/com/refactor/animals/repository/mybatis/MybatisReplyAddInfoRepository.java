package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.dto.ReplyAddInfoParam;
import com.refactor.animals.beans.entity.ReplyAddInfo;
import com.refactor.animals.repository.ReplyAddInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class MybatisReplyAddInfoRepository implements ReplyAddInfoRepository {
    private final ReplyAddInfoMapper mapper;
    @Override
    public int addGood(ReplyAddInfo replyAddInfo) {
        return mapper.addGood(replyAddInfo);
    }

    @Override
    public int addBad(ReplyAddInfo replyAddInfo) {
        return mapper.addBad(replyAddInfo);
    }

    @Override
    public int minGood(ReplyAddInfo replyAddInfo) {
        return mapper.minGood(replyAddInfo);
    }

    @Override
    public int minBad(ReplyAddInfo replyAddInfo) {
        return mapper.minBad(replyAddInfo);
    }

    @Override
    public ReplyAddInfo getReplyAddInfo(ReplyAddInfoParam param) {
        return mapper.getReplyAddInfo(param);
    }

}
