package com.refactor.animals.service;

import com.refactor.animals.beans.dto.PagingResponse;
import com.refactor.animals.beans.dto.SearchDto;
import com.refactor.animals.beans.entity.AnimalBoardVO;

import java.util.List;

public interface AnimalBoardService {

    void insertAnimal(AnimalBoardVO vo);
    PagingResponse<AnimalBoardVO> getAnimalList(SearchDto dto);
    AnimalBoardVO getAnimal(AnimalBoardVO vo);
    List<AnimalBoardVO> getAsideList(AnimalBoardVO vo);

    int count(SearchDto dto);
}
