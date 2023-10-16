package com.refactor.animals.repository;

import com.refactor.animals.beans.dto.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository

public class MemoryMemberRepository implements MemberRepository{
    private static final Map<String, Member> memberRepository = new ConcurrentHashMap<>();
    //private static long sequence = 0L; // static 사용
    public Member save(Member member){
        log.info("save: user={}", member);
        memberRepository.put(member.getLoginId(), member);
        return member;
    }

//    @Override
//    public Optional<Member> findById(String loginId) {
//        return Optional.ofNullable(memberRepository.get(loginId));
//    }

    //아이디 추가 변경하기
    public Optional<Member>findMember(String loginId){
        return findAll().stream()
                .filter(u -> u.getLoginId().equals(loginId))
                .findFirst();
    }

    public List<Member> findAll(){
        return new ArrayList<>(memberRepository.values());
    }

    @Override
    public Optional<Member> isLoginIdDuplicate(String loginId) {
        return findMember(loginId);
    }

    public void clearStore(){
        memberRepository.clear();
    }

}
