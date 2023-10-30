package com.refactor.animals.repository;

import com.refactor.animals.beans.dto.LoginForm;
import com.refactor.animals.beans.entity.Member;
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
        log.info("save: user={}", member.toString());
        memberRepository.put(member.getLoginId(), member);
        return member;
    }

    //아이디 추가 변경하기
    public Optional<Member> findMember(String loginId){
        Member finedMember = memberRepository.get(loginId);
        return Optional.ofNullable(finedMember);

    }

    public Optional<LoginForm> login(String loginId, String password){
        Member member = memberRepository.get(loginId);
        log.info("repo로그인처리 member={}",member);
        if(member!=null){
            LoginForm loginForm = new LoginForm(member.getLoginId(), member.getPassword());
            log.info("로그인 일치 후 반환받은 로그인폼="+loginForm.toString());
            return Optional.of(loginForm);
        }

        return Optional.empty();
    }

    public List<Member> findAll(){
        log.info("findAll() 접근");
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
