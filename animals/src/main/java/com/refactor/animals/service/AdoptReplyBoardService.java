package com.refactor.animals.service;

import com.refactor.animals.beans.dto.ReplyParam;
import com.refactor.animals.beans.entity.AdoptBoardVO;
import com.refactor.animals.beans.entity.AdoptReplyBoardVO;

import java.util.List;

public interface AdoptReplyBoardService {

    int insertReply(ReplyParam vo);
    List<AdoptReplyBoardVO> getReplyList(ReplyParam param);
    int deleteReply(ReplyParam param);

    int addGoodCount(int reply_id); //+1
    int addBadCount(int reply_id);  //+1
    int undoGoodCount(int reply_id); //-1
    int undoBadCount(int reply_id); //-1

}
