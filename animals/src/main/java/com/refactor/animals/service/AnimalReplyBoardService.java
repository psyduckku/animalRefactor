package com.refactor.animals.service;

import com.refactor.animals.beans.entity.AnimalReplyBoardVO;

import java.util.List;

public interface AnimalReplyBoardService {

    List<AnimalReplyBoardVO> boardList(AnimalReplyBoardVO vo);

}