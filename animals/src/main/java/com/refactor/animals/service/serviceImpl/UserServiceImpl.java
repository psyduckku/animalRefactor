package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.converter.JoinFormConverter;
import com.refactor.animals.beans.dto.JoinForm;
import com.refactor.animals.beans.entity.Member;
import com.refactor.animals.beans.dto.LoginForm;
import com.refactor.animals.common.exception.UserException;
import com.refactor.animals.repository.MemoryMemberRepository;
import com.refactor.animals.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    //
    private final MemoryMemberRepository memberRepository; //여기가 그러면 DAO가 있어야함.
    private final BCryptPasswordEncoder encoder; //의존성주입됨
    //optional이 있는 값을 반환하려면 get()이 필요.
    //또한 get()사용하기전에 isPresent()로 값이 있는지 확인이 필요
    @Override
    public LoginForm login(LoginForm loginForm) {
        //loginFormDto에서 Member(entity)로 변경해줘야함
        Optional<Member> member = memberRepository.findMember(loginForm.getLoginId());
        Member finedMember = member.get();
        if(!encoder.matches(loginForm.getPassword(),finedMember.getPassword())){
            throw new UserException("로그인 실패1");
        } else if (member.isEmpty()) {
            throw new UserException("로그인 실패2");
        }
        return new LoginForm(finedMember.getLoginId()); //추후에 바꿔야함. 토큰같은것들 다른데서 보관햇다가 반환해주기
    }
    @Override
    public Member join(JoinForm joinForm) {
        //encoder필요
        log.info("userServiceImpl 진입");
        JoinFormConverter joinFormConverter = new JoinFormConverter();
        Member convertedMember = joinFormConverter.converter(joinForm, encoder);
        Member newMember = memberRepository.save(convertedMember);
        return newMember;
    }

    @Override
    public List<Member> memberList() {
        log.info("memberList접근");
       List<Member> memberList = memberRepository.findAll();
       return memberList;
    }

    @Override
    public boolean isLoginIdDuplicate(String checkId) {
        return memberRepository.findMember(checkId).isPresent();
    }


}
