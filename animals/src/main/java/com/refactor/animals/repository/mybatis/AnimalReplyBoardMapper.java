package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.entity.AnimalReplyBoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnimalReplyBoardMapper {

    List<AnimalReplyBoardVO> boardList(AnimalReplyBoardVO vo);
}
