package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.dto.ReplyParam;
import com.refactor.animals.beans.entity.AnimalReplyBoardVO;
import com.refactor.animals.repository.AnimalReplyBoardRepository;
import com.refactor.animals.service.AnimalReplyBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AnimalReplyBoardServiceImpl implements AnimalReplyBoardService {

    private final AnimalReplyBoardRepository repository;
    @Override
    public List<AnimalReplyBoardVO> getReplyList(AnimalReplyBoardVO vo) {
        return repository.getReplyList(vo);
    }

    @Override
    public int insertReply(ReplyParam vo) {
        return repository.insertReply(vo);
    }
}
