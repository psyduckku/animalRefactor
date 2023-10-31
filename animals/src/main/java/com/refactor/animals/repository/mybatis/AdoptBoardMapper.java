package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.dto.SearchDto;
import com.refactor.animals.beans.entity.AdoptBoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdoptBoardMapper {

    public AdoptBoardVO inserBoard(AdoptBoardVO vo);
    public List<AdoptBoardVO> boardList(SearchDto dto);
    public AdoptBoardVO getBoard(AdoptBoardVO vo);
    public List<AdoptBoardVO> selectBoard(SearchDto dto);
    public int count(SearchDto dto);
}
