package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.dto.ReplyAddInfoParam;
import com.refactor.animals.beans.entity.ReplyAddInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyAddInfoMapper {
    int insertReplyAddInfo(ReplyAddInfo ReplyAddInfo);
    ReplyAddInfo getReplyAddInfo(ReplyAddInfoParam param);

}
