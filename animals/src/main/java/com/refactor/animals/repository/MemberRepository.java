package com.refactor.animals.repository;

import com.refactor.animals.beans.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findMember(String loginId);
    List<Member> findAll();
    Optional<Member> isLoginIdDuplicate(String loginId);



}
