package com.refactor.animals.service;

import com.refactor.animals.beans.dto.PagingResponse;
import com.refactor.animals.beans.dto.SearchDto;
import com.refactor.animals.beans.entity.AdoptBoardVO;

import java.util.List;

public interface AdoptBoardService {

    public PagingResponse<AdoptBoardVO> boardList(SearchDto dto);
    public AdoptBoardVO getBoard(AdoptBoardVO vo);
    public AdoptBoardVO inserBoard(AdoptBoardVO vo);
    public void update(AdoptBoardVO vo);
    public int count(SearchDto dto);
}
