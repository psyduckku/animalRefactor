package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.dto.ReplyParam;
import com.refactor.animals.beans.entity.AdoptBoardVO;
import com.refactor.animals.beans.entity.AdoptReplyBoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdoptReplyBoardMapper {

    int insertReply(AdoptReplyBoardVO vo);
    List<AdoptReplyBoardVO> getReplyList(ReplyParam param);
    AdoptReplyBoardVO checkEvaluation(ReplyParam param);
    int deleteReply(ReplyParam param);

    int addGoodCount(int reply_id); //+1
    int addBadCount(int reply_id);  //+1
    int undoGoodCount(int reply_id); //-1
    int undoBadCount(int reply_id); //-1

}
