package com.refactor.animals.service;

import com.refactor.animals.beans.dto.ReplyParam;
import com.refactor.animals.beans.entity.AdoptBoardVO;
import com.refactor.animals.beans.entity.AdoptReplyBoardVO;

import java.util.List;

public interface AdoptReplyBoardService {

    int insertReply(AdoptReplyBoardVO vo);
    List<AdoptReplyBoardVO> getReplyList(ReplyParam param);
    int deleteReply(ReplyParam param);

}
