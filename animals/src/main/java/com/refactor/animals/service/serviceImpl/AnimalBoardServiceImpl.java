package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.dto.Pagination;
import com.refactor.animals.beans.dto.PagingResponse;
import com.refactor.animals.beans.dto.SearchDto;
import com.refactor.animals.beans.entity.AnimalBoardVO;
import com.refactor.animals.repository.AnimalBoardRepository;
import com.refactor.animals.service.AnimalBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
//@Service
public class AnimalBoardServiceImpl implements AnimalBoardService {

    //repository를 주입받을거, repository에서 mapper가 활동함
    private final AnimalBoardRepository animalBoardRepository;
//    private final AnimalBoardDAO animalBoardDAO;

//    private AnimalBoardMapper animalBoardMapper; //얘때문에 넣어야할게 증가함./.

    @Override
    public void insertAnimal(AnimalBoardVO vo) {
        animalBoardRepository.insertAnimal(vo);
    }

    @Override
    public PagingResponse<AnimalBoardVO> getAnimalList(SearchDto params) {
        //조건에 해당하는 데이터가 없는 경우, 응답 데이터에 비어있는 리스트와 null을 담아 반환
//        AnimalBoardMapper animalBoardMapper = new

        int count =animalBoardRepository.count(params);
        if(count<1){
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        //Pagination 객체를 생성해서 페이지 정보 계산 후 SearchDto타입의 객체인 params에 계산된 페이지 정보 저장

        Pagination pagination = new Pagination(count, params); //이부분이 문제임***
        log.info("impl pagination object ={}",pagination);
        params.setPagination(pagination);

        //계산된 페이지 정보의 일부(limitStart, recordSize)를 기준으로 리스트 데이터 조회 후 응답 데이터 반환
        List<AnimalBoardVO> list = animalBoardRepository.getAnimalList(params);
        log.info("getAnimalList Impl list={}", list.toString());
        return new PagingResponse<>(list, pagination);
    }

    @Override
    public AnimalBoardVO getAnimal(AnimalBoardVO vo) {
        return animalBoardRepository.getAnimal(vo);
    }

    @Override
    public List<AnimalBoardVO> getAsideList(AnimalBoardVO vo) {
        return animalBoardRepository.getAsideList(vo);
    }

    @Override
    public int count(SearchDto params) {
        int count = animalBoardRepository.count(params);
        log.info("count={}",count);
        return count;
    }
}