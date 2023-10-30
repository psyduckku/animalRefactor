package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberMapper {
    Member save(Member member);
    Optional<Member> findMember(String loginId);
    List<Member> findAll();
    Optional<Member> isLoginIdDuplicate(String loginId);

}
