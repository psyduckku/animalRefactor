package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.dto.ReplyParam;
import com.refactor.animals.beans.entity.AdoptReplyBoardVO;
import com.refactor.animals.repository.AdoptReplyBoardRepository;
import com.refactor.animals.service.AdoptReplyBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdoptReplyBoardServiceImpl implements AdoptReplyBoardService {

    private final AdoptReplyBoardRepository repository;

    @Override
    public int insertReply(AdoptReplyBoardVO vo) {
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

}
