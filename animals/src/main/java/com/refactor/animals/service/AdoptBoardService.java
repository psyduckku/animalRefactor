package com.refactor.animals.service;

import com.refactor.animals.beans.dto.PagingResponse;
import com.refactor.animals.beans.dto.SearchDto;
import com.refactor.animals.beans.entity.AdoptBoardBookMarkVO;
import com.refactor.animals.beans.entity.AdoptBoardVO;
import com.refactor.animals.beans.entity.ThumbnailVO;

import java.util.List;

public interface AdoptBoardService {

    PagingResponse<AdoptBoardVO> boardList(SearchDto dto);
    AdoptBoardVO getBoard(AdoptBoardVO vo);
    int insertBoard(AdoptBoardVO vo);
    void cntUpdate(AdoptBoardVO vo);
    int boardCount(SearchDto dto);
    int bookmarkCount();
    int bookmark(AdoptBoardVO vo);
    List<AdoptBoardBookMarkVO> bookmarkList();
    int deleteBoard(int adt_id);
    int updateBoard(AdoptBoardVO vo);

}
