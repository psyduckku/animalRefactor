package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.dto.JoinForm;
import com.refactor.animals.beans.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    void save(Member member);
    Optional<Member> findMember(String loginId);
    List<Member> findAll();
    Optional<Member> isLoginIdDuplicate(String loginId);

}
