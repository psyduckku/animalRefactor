package com.refactor.animals.repository;

import com.refactor.animals.beans.dto.ReplyParam;
import com.refactor.animals.beans.entity.AdoptBoardVO;
import com.refactor.animals.beans.entity.AdoptReplyBoardVO;

import java.util.List;

public interface AdoptReplyBoardRepository {

    int insertReply(AdoptReplyBoardVO vo);
    List<AdoptReplyBoardVO> getReplyList(ReplyParam param);
    AdoptReplyBoardVO checkEvaluation(ReplyParam param);
    int goodEvaluation(ReplyParam param);
    int badEvaluation(ReplyParam param);
    int deleteReply(ReplyParam param);

}
