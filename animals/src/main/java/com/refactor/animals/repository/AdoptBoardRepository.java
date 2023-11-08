package com.refactor.animals.repository;

import com.refactor.animals.beans.dto.PagingResponse;
import com.refactor.animals.beans.dto.SearchDto;
import com.refactor.animals.beans.entity.AdoptBoardVO;

import java.util.List;

public interface AdoptBoardRepository {

    public List<AdoptBoardVO> boardList(SearchDto dto);
    public AdoptBoardVO getBoard(AdoptBoardVO vo);
    public AdoptBoardVO inserBoard(AdoptBoardVO vo);
    public int count(SearchDto dto);

    public int update(AdoptBoardVO vo);

}
