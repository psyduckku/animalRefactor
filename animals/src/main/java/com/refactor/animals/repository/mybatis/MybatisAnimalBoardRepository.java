package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.dto.SearchDto;
import com.refactor.animals.beans.entity.AnimalBoardVO;
import com.refactor.animals.repository.AnimalBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
//@Repository
@RequiredArgsConstructor
public class MybatisAnimalBoardRepository implements AnimalBoardRepository {

    private final AnimalBoardMapper mapper;

    @Override
    public void insertAnimal(AnimalBoardVO vo) {
        mapper.insertAnimal(vo);
    }

    @Override
    public List<AnimalBoardVO> getAnimalList(SearchDto dto) {
        List<AnimalBoardVO> list = mapper.getAnimalList(dto);
        log.info("MybatisRepository list={}", list);
        return list;
    }

    @Override
    public AnimalBoardVO getAnimal(AnimalBoardVO vo) {
        return mapper.getAnimal(vo);
    }

    @Override
    public List<AnimalBoardVO> getAsideList(AnimalBoardVO vo) {
        return mapper.getAsideList(vo);
    }

    @Override
    public int count(SearchDto dto) {
        return mapper.count(dto);
    }
}
