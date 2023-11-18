package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.dto.SearchDto;
import com.refactor.animals.beans.entity.AdoptBoardBookMarkVO;
import com.refactor.animals.beans.entity.AdoptBoardVO;
import com.refactor.animals.repository.AdoptBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Repository
public class MybatisAdoptBoardRepository implements AdoptBoardRepository {


    private final AdoptBoardMapper mapper;

    @Override
    public List<AdoptBoardVO> boardList(SearchDto dto) {
        return mapper.boardList(dto);
    }

    @Override
    public AdoptBoardVO getBoard(AdoptBoardVO vo) {
        return mapper.getBoard(vo);
    }

    @Override
    public int insertBoard(AdoptBoardVO vo) {
        log.info("mybatis repo vo.toString()={}",vo.toString());
         mapper.insertBoard(vo);

        return vo.getAdt_id();
    }

    @Override
    public int boardCount(SearchDto dto) {
        return mapper.boardCount(dto);
    }

    @Override
    public int cntUpdate(AdoptBoardVO vo) {
         int row = mapper.cntUpdate(vo);
         return row;
    }

    @Override
    public int bookmarkCount() {
        return mapper.bookmarkCount();
    }

    @Override
    public int bookmark(AdoptBoardVO vo) {
        return mapper.bookmark(vo);
    }

    @Override
    public List<AdoptBoardBookMarkVO> bookmarkList() {
        return mapper.bookmarkList();
    }
}
