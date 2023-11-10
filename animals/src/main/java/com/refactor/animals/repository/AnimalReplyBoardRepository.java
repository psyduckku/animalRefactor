package com.refactor.animals.repository;

import com.refactor.animals.beans.entity.AnimalReplyBoardVO;

import java.util.List;

public interface AnimalReplyBoardRepository {
    public List<AnimalReplyBoardVO> boardList(AnimalReplyBoardVO vo);

}
