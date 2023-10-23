package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.entity.AnimalBoardVO;
import com.refactor.animals.repository.MemberRepository;
import com.refactor.animals.service.AnimalBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("AnimalBoardService")
public class AnimalBoardServiceImpl implements AnimalBoardService {

    private final AnimalBoardDAO animalBoardDAO;
    private final MemberRepository memberRepository;

    @Override
    public void insertAnimal(AnimalBoardVO vo) {

    }

    @Override
    public List<AnimalBoardVO> getAnimalList(AnimalBoardVO vo) {
        return null;
    }

    @Override
    public AnimalBoardVO getAnimal(AnimalBoardVO vo) {
        return null;
    }

    @Override
    public List<AnimalBoardVO> getAsideList(AnimalBoardVO vo) {
        return null;
    }
}