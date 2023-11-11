package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.dto.PagingResponse;
import com.refactor.animals.beans.dto.SearchDto;
import com.refactor.animals.beans.entity.AdoptBoardVO;
import com.refactor.animals.repository.AdoptBoardRepository;
import com.refactor.animals.repository.mybatis.AdoptBoardMapper;
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
    public int count(SearchDto dto) {
        return mapper.count(dto);
    }

    @Override
    public int update(AdoptBoardVO vo) {
         int row = mapper.update(vo);
         return row;
    }
}
