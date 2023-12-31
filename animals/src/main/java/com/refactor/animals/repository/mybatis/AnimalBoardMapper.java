package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.dto.SearchDto;
import com.refactor.animals.beans.entity.AnimalBoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //resources의 mybatis xml와 일치 시켜야함
public interface AnimalBoardMapper {
//mybatis
    void insertAnimal(AnimalBoardVO vo);
    List<AnimalBoardVO> getAnimalList(SearchDto dto);
    AnimalBoardVO getAnimal(AnimalBoardVO vo);
    List<AnimalBoardVO> getAsideList(AnimalBoardVO vo);

    int count(SearchDto dto);

}
