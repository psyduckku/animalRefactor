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


}
