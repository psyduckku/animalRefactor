package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.entity.AnimalBoardVO;
import com.refactor.animals.repository.mybatis.AnimalBoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository //DAO에게 위임
public class AnimalBoardDAO {

    private final AnimalBoardMapper mapper; //repository할 일을 mapper에게 위임



    public void insertAnimal(AnimalBoardVO vo) {
        System.out.println("Mybatis로 insertAnimal() 처리");
        mapper.insertAnimal(vo);

    }

    public List<AnimalBoardVO> getAnimalList(AnimalBoardVO vo) {
        System.out.println("Mybatis로 getAnimalList() 처리");
        return mapper.getAnimalList(vo);
    }

    public AnimalBoardVO getAnimal(AnimalBoardVO vo) {
        System.out.println("Mybatis로 getAnimal()처리");
        return mapper.getAnimal(vo);
    }

    public List<AnimalBoardVO> getAsideList(AnimalBoardVO vo) {
        System.out.println("Mybatis로 getAsideList() 처리");
        return mapper.getAsideList(vo);
    }

}
