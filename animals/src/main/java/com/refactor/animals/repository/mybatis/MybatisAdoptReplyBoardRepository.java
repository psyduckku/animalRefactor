package com.refactor.animals.repository.mybatis;


import com.refactor.animals.beans.dto.ReplyParam;
import com.refactor.animals.beans.entity.AdoptReplyBoardVO;
import com.refactor.animals.repository.AdoptReplyBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Repository
public class MybatisAdoptReplyBoardRepository implements AdoptReplyBoardRepository {
    private final AdoptReplyBoardMapper mapper;

    @Override
    public int insertReply(ReplyParam vo) {
        log.info("repo insert");
        return mapper.insertReply(vo);
    }
    @Override
    public List<AdoptReplyBoardVO> getReplyList(ReplyParam param) {
        return mapper.getReplyList(param);
    }

    @Override
    public int deleteReply(ReplyParam param) {
        return mapper.deleteReply(param);
    }

    @Override
    public int addGoodCount(int reply_id) {
        return mapper.addGoodCount(reply_id);
    }

    @Override
    public int addBadCount(int reply_id) {
        return mapper.addBadCount(reply_id);
    }

    @Override
    public int undoGoodCount(int reply_id) {
        return mapper.undoGoodCount(reply_id);
    }

    @Override
    public int undoBadCount(int reply_id) {
        return mapper.undoBadCount(reply_id);
    }

}
