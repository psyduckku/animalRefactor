package com.refactor.animals.service;

import com.refactor.animals.beans.dto.PagingResponse;
import com.refactor.animals.beans.dto.SearchDto;
import com.refactor.animals.beans.entity.AdoptBoardVO;

import java.util.List;

public interface AdoptBoardService {

    PagingResponse<AdoptBoardVO> boardList(SearchDto dto);
    AdoptBoardVO getBoard(AdoptBoardVO vo);
    AdoptBoardVO inserBoard(AdoptBoardVO vo);
    void update(AdoptBoardVO vo);
    int count(SearchDto dto);
}
