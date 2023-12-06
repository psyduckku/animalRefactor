package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.dto.ReplyParam;
import com.refactor.animals.beans.entity.AdoptReplyBoardVO;
import com.refactor.animals.beans.entity.ReplyAddInfo;
import com.refactor.animals.repository.AdoptReplyBoardRepository;
import com.refactor.animals.service.AdoptReplyBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdoptReplyBoardServiceImpl implements AdoptReplyBoardService {

    private final AdoptReplyBoardRepository repository;

    @Override
    public int insertReply(ReplyParam vo) {
        log.info("insertReplyImpl");
        return repository.insertReply(vo);
    }
    @Override
    public List<AdoptReplyBoardVO> getReplyList(ReplyParam param) {
        if(param.getOrderby()==null){
            param.setOrderby("desc");
        }
        return repository.getReplyList(param);
    }

    @Override
    public int deleteReply(ReplyParam param) {
        return repository.deleteReply(param);
    }

    @Override
    public int addGoodCount(int reply_id) {
        return repository.addGoodCount(reply_id);
    }

    @Override
    public int addBadCount(int reply_id) {
        return repository.addBadCount(reply_id);
    }

    @Override
    public int undoGoodCount(int reply_id) {
        return repository.undoGoodCount(reply_id);
    }

    @Override
    public int undoBadCount(int reply_id) {
        return repository.undoBadCount(reply_id);
    }

}
