package com.refactor.animals.repository;

import com.refactor.animals.beans.dto.ReplyParam;
import com.refactor.animals.beans.entity.AnimalReplyBoardVO;

import java.util.List;

public interface AnimalReplyBoardRepository {
    List<AnimalReplyBoardVO> getReplyList(AnimalReplyBoardVO vo);
    int insertReply(ReplyParam vo);

}
