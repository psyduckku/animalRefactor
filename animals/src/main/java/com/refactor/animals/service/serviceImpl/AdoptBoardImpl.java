package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.dto.Pagination;
import com.refactor.animals.beans.dto.PagingResponse;
import com.refactor.animals.beans.dto.SearchDto;
import com.refactor.animals.beans.entity.AdoptBoardBookMarkVO;
import com.refactor.animals.beans.entity.AdoptBoardVO;
import com.refactor.animals.beans.entity.ThumbnailVO;
import com.refactor.animals.exception.UserException;
import com.refactor.animals.repository.mybatis.MybatisAdoptBoardRepository;
import com.refactor.animals.service.AdoptBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

        int count = repository.boardCount(params);
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
            log.info("조회수확인");
            repository.cntUpdate(board); //조회수 증가
            return board;
        }else{
            throw new UserException("게시물을 찾을 수 없습니다");
        }

    }

    @Override
    public int insertBoard(AdoptBoardVO vo) {
        log.info("impl vo.toString()={}", vo.toString());
        repository.insertBoard(vo);
        log.info("insert에 대한 auto_increment key="+vo.getAdt_id());
        return vo.getAdt_id();
    }

    @Override
    public void cntUpdate(AdoptBoardVO vo) {
        repository.cntUpdate(vo);
    }

    @Override
    public int boardCount(SearchDto params) {
        return repository.boardCount(params);
    }

    @Override
    public int bookmarkCount() {
        return repository.bookmarkCount();
    }

    @Override
    public int bookmark(AdoptBoardVO vo) {
        return repository.bookmark(vo);
    }

    @Override
    public List<AdoptBoardBookMarkVO> bookmarkList() {
        return repository.bookmarkList();
    }

    @Override
    public int deleteBoard(int adt_id) {
        return repository.deleteBoard(adt_id);
    }

    @Override
    public int updateBoard(AdoptBoardVO vo) {
        return repository.updateBoard(vo);
    }
}
