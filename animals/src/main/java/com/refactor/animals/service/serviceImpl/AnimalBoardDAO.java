package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.entity.AnimalBoardVO;
import com.refactor.animals.repository.mybatis.AnimalBoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
//@Repository //DAO->mapper
public class AnimalBoardDAO {

    //얘 안씀. DAO오 안쓰고 Repo에서 Mapper 주입으로 사용할거
    private final AnimalBoardMapper mapper; //repository할 일을 mapper에게 위임

    public void insertAnimal(AnimalBoardVO vo) {
        log.info("Mybatis로 insertAnimal() 처리");
        mapper.insertAnimal(vo);

    }

    public List<AnimalBoardVO> getAnimalList(AnimalBoardVO vo) {

        List<AnimalBoardVO> list = mapper.getAnimalList(vo);
        log.info("Mybatis로 getAnimalList() 처리 list={}", list);
        return list;
    }

    public AnimalBoardVO getAnimal(AnimalBoardVO vo) {
        log.info("Mybatis로 getAnimal()처리");
        return mapper.getAnimal(vo);
    }

    public List<AnimalBoardVO> getAsideList(AnimalBoardVO vo) {
        log.info("Mybatis로 getAsideList() 처리");
        return mapper.getAsideList(vo);
    }

}
