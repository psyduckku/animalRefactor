package com.refactor.animals.repository;

import com.refactor.animals.beans.entity.AnimalBoardVO;
import com.refactor.animals.repository.mybatis.AnimalBoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MybatisAnimalBoardRepository implements AnimalBoardRepository{

    private final AnimalBoardMapper mapper;

    @Override
    public void insertAnimal(AnimalBoardVO vo) {
        mapper.insertAnimal(vo);
    }

    @Override
    public List<AnimalBoardVO> getAnimalList(AnimalBoardVO vo) {
        return mapper.getAnimalList(vo);
    }

    @Override
    public AnimalBoardVO getAnimal(AnimalBoardVO vo) {
        return mapper.getAnimal(vo);
    }

    @Override
    public List<AnimalBoardVO> getAsideList(AnimalBoardVO vo) {
        return mapper.getAsideList(vo);
    }
}
