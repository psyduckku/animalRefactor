package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.dto.Pagination;
import com.refactor.animals.beans.dto.PagingResponse;
import com.refactor.animals.beans.dto.SearchDto;
import com.refactor.animals.beans.entity.AdoptBoardVO;
import com.refactor.animals.exception.UserException;
import com.refactor.animals.repository.mybatis.MybatisAdoptBoardRepository;
import com.refactor.animals.service.AdoptBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdoptBoardImpl implements AdoptBoardService {

    private final MybatisAdoptBoardRepository repository;
    @Override
    public PagingResponse<AdoptBoardVO> boardList(SearchDto params) {

        int count = repository.count(params);
        if(count < 1){
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        Pagination pagination = new Pagination(count, params);
        log.info("impl pagination ={}",pagination);
        params.setPagination(pagination);

        List<AdoptBoardVO> list = repository.boardList(params);
        return new PagingResponse<>(list, pagination);
    }


    @Override
    public AdoptBoardVO getBoard(AdoptBoardVO vo) { //해당 vo에는 보드 id만있음
        AdoptBoardVO board = repository.getBoard(vo);
        if(board!=null){
            board.setCnt(board.getCnt()+1);
            repository.update(board); //조회수 증가
            return board;
        }else{
            throw new UserException("게시물을 찾을 수 없습니다");
        }

    }

    @Override
    public AdoptBoardVO inserBoard(AdoptBoardVO vo) {
        return repository.inserBoard(vo);
    }

    @Override
    public void update(AdoptBoardVO vo) {
        repository.update(vo);
    }

    @Override
    public int count(SearchDto params) {
        return repository.count(params);
    }
}
