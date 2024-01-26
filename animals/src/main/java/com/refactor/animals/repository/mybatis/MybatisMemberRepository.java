package com.refactor.animals.repository.mybatis;

import com.refactor.animals.beans.entity.MemberVO;
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
    public HttpStatus save(MemberVO member) {
        mapper.save(member);
        return HttpStatus.OK;
    }

    @Override
    public Optional<MemberVO> findMember(String loginId) {
        return mapper.findMember(loginId);
    }

    @Override
    public List<MemberVO> findAll() {
        return mapper.findAll();
    }

    @Override
    public Optional<MemberVO> isLoginIdDuplicate(String loginId) {
        return mapper.isLoginIdDuplicate(loginId);
    }

    @Override
    public void updateAccessTime(MemberVO vo) {
        mapper.updateAccessTime(vo);
    }


}
