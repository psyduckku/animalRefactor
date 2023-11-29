package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.entity.ReplyAddInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyAddInfoMapper {
    int insertReplyAddInfo(ReplyAddInfo ReplyAddInfo);

}
