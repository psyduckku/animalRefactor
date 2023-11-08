package com.refactor.animals.repository;

import com.refactor.animals.beans.dto.LoginForm;
import com.refactor.animals.beans.entity.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
//@Repository
public class MemoryMemberRepository implements MemberRepository{
    private static final Map<String, MemberVO> memberRepository = new ConcurrentHashMap<>();
    //private static long sequence = 0L; // static 사용
    public HttpStatus save(MemberVO member){
        log.info("save: user={}", member.toString());
        memberRepository.put(member.getLogin_id(), member);
        return HttpStatus.OK;
    }

    //아이디 추가 변경하기
    public Optional<MemberVO> findMember(String login_id){
        MemberVO finedMember = memberRepository.get(login_id);
        return Optional.ofNullable(finedMember);

    }

    public Optional<LoginForm> login(String login_id, String password){
        MemberVO member = memberRepository.get(login_id);
        log.info("repo로그인처리 member={}",member);
        if(member!=null){
            LoginForm loginForm = new LoginForm(member.getLogin_id(), member.getPassword());
            log.info("로그인 일치 후 반환받은 로그인폼="+loginForm.toString());
            return Optional.of(loginForm);
        }

        return Optional.empty();
    }

    public List<MemberVO> findAll(){
        log.info("findAll() 접근");
        return new ArrayList<>(memberRepository.values());
    }

    @Override
    public Optional<MemberVO> isLoginIdDuplicate(String login_id) {
        return findMember(login_id);
    }

    public void clearStore(){
        memberRepository.clear();
    }

}
