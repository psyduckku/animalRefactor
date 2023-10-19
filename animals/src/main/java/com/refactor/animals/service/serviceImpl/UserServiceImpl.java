package com.refactor.animals.service.serviceImpl;

import ch.qos.logback.classic.spi.IThrowableProxy;
import com.refactor.animals.beans.converter.JoinFormConverter;
import com.refactor.animals.beans.converter.LoginFormConverter;
import com.refactor.animals.beans.dto.JoinForm;
import com.refactor.animals.beans.dto.Member;
import com.refactor.animals.beans.dto.LoginForm;
import com.refactor.animals.exception.UserException;
import com.refactor.animals.repository.MemoryMemberRepository;
import com.refactor.animals.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    //
    private final MemoryMemberRepository memoryMemberRepository;
    private final BCryptPasswordEncoder encoder;
    //optional이 있는 값을 반환하려면 get()이 필요.
    //또한 get()사용하기전에 isPresent()로 값이 있는지 확인이 필요
    @Override
    public LoginForm login(LoginForm loginForm) {
        LoginFormConverter loginFormConverter = new LoginFormConverter();
        Member memberDTO = loginFormConverter.converter(loginForm, encoder);
        Optional<LoginForm> member = memoryMemberRepository.login(memberDTO.getLoginId(), memberDTO.getPassword());
        //비밀번호 일치 조건 확인해야함.
        if(!member.isPresent()){
            throw new UserException("로그인 실패"); //따로
        }
        return member.get();
    }
    @Override
    public Member join(JoinForm joinForm) {
        //encoder필요
        log.info("userServiceImpl 진입");
        JoinFormConverter joinFormConverter = new JoinFormConverter();
        Member convertedMember = joinFormConverter.converter(joinForm, encoder);
        Member newMember = memoryMemberRepository.save(convertedMember);
        return newMember;
    }

    @Override
    public Optional<List<Member>> memberList() {
       Optional<List<Member>> memberList = memoryMemberRepository.findAll();
       return memberList;
    }

    @Override
    public boolean isLoginIdDuplicate(String checkId) {
        return memoryMemberRepository.findMember(checkId).isPresent();
    }


}
