package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.entity.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    void save(MemberVO member);
    Optional<MemberVO> findMember(String loginId);
    List<MemberVO> findAll();
    Optional<MemberVO> isLoginIdDuplicate(String loginId);
    void updateAccessTime(MemberVO vo);

}
