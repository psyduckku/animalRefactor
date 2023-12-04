package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.entity.ReplyAddInfo;
import com.refactor.animals.repository.ReplyAddInfoRepository;
import com.refactor.animals.service.ReplyAddInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class ReplyAddInfoServiceImpl implements ReplyAddInfoService {

    private final ReplyAddInfoRepository repository;

    @Override
    public int insertReplyAddInfo(ReplyAddInfo replyAddInfo) {
//        if(replyAddInfo.getTable_name()==null){
//            replyAddInfo.setTable_name("adopt_board");
//        }
        return repository.insertReplyAddInfo(replyAddInfo);
    }
}
