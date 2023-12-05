package com.refactor.animals.service;

import com.refactor.animals.beans.dto.ReplyAddInfoParam;
import com.refactor.animals.beans.entity.ReplyAddInfo;


public interface ReplyAddInfoService {

    int insertReplyAddInfo(ReplyAddInfo ReplyAddInfo);
    ReplyAddInfo getReplyAddInfo(ReplyAddInfoParam param);
}
