package com.refactor.animals.repository;

import com.refactor.animals.beans.entity.AnimalBoardVO;

import java.util.List;

public interface AnimalBoardRepository {

    void insertAnimal(AnimalBoardVO vo);
    List<AnimalBoardVO> getAnimalList(AnimalBoardVO vo);
    AnimalBoardVO getAnimal(AnimalBoardVO vo);
    List<AnimalBoardVO> getAsideList(AnimalBoardVO vo);
    
}
