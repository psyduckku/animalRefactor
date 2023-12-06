package com.refactor.animals.service;

import com.refactor.animals.beans.dto.ReplyAddInfoParam;
import com.refactor.animals.beans.entity.ReplyAddInfo;


public interface ReplyAddInfoService {

    int addGood(ReplyAddInfo param);
    int addBad(ReplyAddInfo param);
    int minGood(ReplyAddInfo param);
    int minBad(ReplyAddInfo param);
    ReplyAddInfo getReplyAddInfo(ReplyAddInfoParam param);
}
