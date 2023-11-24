package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.entity.AnimalReplyBoardVO;
import com.refactor.animals.repository.AnimalReplyBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
@Slf4j
@Repository
@RequiredArgsConstructor
public class MybatisAnimalReplyBoardRepository implements AnimalReplyBoardRepository {

    private final AnimalReplyBoardMapper mapper;
    @Override
    public List<AnimalReplyBoardVO> boardList(AnimalReplyBoardVO vo) {
        return mapper.boardList(vo);
    }

    @Override
    public int insertReply(AnimalReplyBoardVO vo) {
        return mapper.insertReply(vo);
    }


}
