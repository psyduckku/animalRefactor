package com.refactor.animals.repository;

import com.refactor.animals.beans.entity.MemberVO;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    HttpStatus save(MemberVO member);
    Optional<MemberVO> findMember(String loginId);
    List<MemberVO> findAll();
    Optional<MemberVO> isLoginIdDuplicate(String loginId);
    void updateAccessTime(MemberVO vo);


}
