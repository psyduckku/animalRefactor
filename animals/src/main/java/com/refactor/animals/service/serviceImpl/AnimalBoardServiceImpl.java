package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.entity.AnimalBoardVO;
import com.refactor.animals.repository.AnimalBoardRepository;
import com.refactor.animals.repository.MemberRepository;
import com.refactor.animals.repository.mybatis.AnimalBoardMapper;
import com.refactor.animals.service.AnimalBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AnimalBoardServiceImpl implements AnimalBoardService {

    //repository를 주입받을거, repository에서 mapper가 활동함
    private final AnimalBoardRepository animalBoardRepository;
//    private final AnimalBoardDAO animalBoardDAO;

    @Override
    public void insertAnimal(AnimalBoardVO vo) {
        animalBoardRepository.insertAnimal(vo);
    }

    @Override
    public List<AnimalBoardVO> getAnimalList(AnimalBoardVO vo) {
        log.info("getAnimalList Impl");
        List<AnimalBoardVO> list = animalBoardRepository.getAnimalList(vo);
        log.info("getAnimalList Impl list={}", list);
        return list;
    }

    @Override
    public AnimalBoardVO getAnimal(AnimalBoardVO vo) {
        return animalBoardRepository.getAnimal(vo);
    }

    @Override
    public List<AnimalBoardVO> getAsideList(AnimalBoardVO vo) {
        return animalBoardRepository.getAsideList(vo);
    }
}