package com.refactor.animals.repository.mybatis;


import com.refactor.animals.beans.dto.ReplyParam;
import com.refactor.animals.beans.entity.AdoptReplyBoardVO;
import com.refactor.animals.repository.AdoptReplyBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class MybatisAdoptReplyBoardRepository implements AdoptReplyBoardRepository {
    private final AdoptReplyBoardMapper mapper;

    @Override
    public int insertReply(AdoptReplyBoardVO vo) {
        return mapper.insertReply(vo);
    }
    @Override
    public List<AdoptReplyBoardVO> getReplyList(ReplyParam param) {
        return mapper.getReplyList(param);
    }

    @Override
    public AdoptReplyBoardVO checkEvaluation(ReplyParam param) {
        return mapper.checkEvaluation(param);
    }

    @Override
    public int goodEvaluation(ReplyParam param) {
        return mapper.goodEvaluation(param);
    }

    @Override
    public int badEvaluation(ReplyParam param) {
        return mapper.badEvaluation(param);
    }

    @Override
    public int deleteReply(ReplyParam param) {
        return mapper.deleteReply(param);
    }

}
