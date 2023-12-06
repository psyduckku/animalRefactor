package com.refactor.animals.repository;

import com.refactor.animals.beans.dto.ReplyAddInfoParam;
import com.refactor.animals.beans.entity.ReplyAddInfo;

import java.util.List;

public interface ReplyAddInfoRepository {
    int addGood(ReplyAddInfo replyAddInfo);
    int addBad(ReplyAddInfo replyAddInfo);
    int minGood(ReplyAddInfo replyAddInfo);
    int minBad(ReplyAddInfo replyAddInfo);
    ReplyAddInfo getReplyAddInfo(ReplyAddInfoParam param);
}
