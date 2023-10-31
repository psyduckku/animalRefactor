package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.entity.Member;
import com.refactor.animals.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MybatisMemberRepository implements MemberRepository {

    private final MemberMapper mapper;

    @Override
    public HttpStatus save(Member member) {
        mapper.save(member);
        return HttpStatus.OK;
    }

    @Override
    public Optional<Member> findMember(String loginId) {
        return mapper.findMember(loginId);
    }

    @Override
    public List<Member> findAll() {
        return mapper.findAll();
    }

    @Override
    public Optional<Member> isLoginIdDuplicate(String loginId) {
        return mapper.isLoginIdDuplicate(loginId);
    }
}
