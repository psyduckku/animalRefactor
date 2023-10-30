package com.refactor.animals.repository;

import com.refactor.animals.beans.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MybatisMemberRepository implements MemberRepository{


    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Optional<Member> findMember(String loginId) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public Optional<Member> isLoginIdDuplicate(String loginId) {
        return Optional.empty();
    }
}
