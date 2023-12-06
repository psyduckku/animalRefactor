package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.dto.ReplyAddInfoParam;
import com.refactor.animals.beans.entity.ReplyAddInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyAddInfoMapper {
    int addGood(ReplyAddInfo replyAddInfo);
    int addBad(ReplyAddInfo replyAddInfo);
    int minGood(ReplyAddInfo replyAddInfo);
    int minBad(ReplyAddInfo replyAddInfo);
    ReplyAddInfo getReplyAddInfo(ReplyAddInfoParam param);

}
