package com.refactor.animals.repository;

import com.refactor.animals.beans.dto.ReplyAddInfoParam;
import com.refactor.animals.beans.entity.ReplyAddInfo;

import java.util.List;

public interface ReplyAddInfoRepository {
    int insertReplyAddInfo(ReplyAddInfo ReplyAddInfo);
    ReplyAddInfo getReplyAddInfo(ReplyAddInfoParam param);
}
