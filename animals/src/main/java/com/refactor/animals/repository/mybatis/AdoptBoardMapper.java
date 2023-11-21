package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.dto.SearchDto;
import com.refactor.animals.beans.entity.AdoptBoardBookMarkVO;
import com.refactor.animals.beans.entity.AdoptBoardVO;
import com.refactor.animals.beans.entity.ThumbnailVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdoptBoardMapper {

    int insertBoard(AdoptBoardVO vo);
    List<AdoptBoardVO> boardList(SearchDto dto);
    AdoptBoardVO getBoard(AdoptBoardVO vo);
    int boardCount(SearchDto dto);
    int cntUpdate(AdoptBoardVO vo);
    int bookmarkCount();
    int bookmark(AdoptBoardVO vo);
    List<AdoptBoardBookMarkVO> bookmarkList();
    int deleteBoard(int adt_id);

}
