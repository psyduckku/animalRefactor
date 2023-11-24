package com.refactor.animals.repository;

import com.refactor.animals.beans.entity.AnimalReplyBoardVO;

import java.util.List;

public interface AnimalReplyBoardRepository {
    List<AnimalReplyBoardVO> boardList(AnimalReplyBoardVO vo);
    int insertReply(AnimalReplyBoardVO vo);

}
