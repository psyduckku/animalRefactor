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
    public int insertReplyAddInfo(ReplyAddInfo replyAddInfo) {
        return mapper.insertReplyAddInfo(replyAddInfo);
    }

    @Override
    public ReplyAddInfo getReplyAddInfo(ReplyAddInfoParam param) {
        return mapper.getReplyAddInfo(param);
    }

}
