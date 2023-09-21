package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.converter.JoinFormConverter;
import com.refactor.animals.beans.converter.LoginFormConverter;
import com.refactor.animals.beans.dto.joinForm;
import com.refactor.animals.beans.dto.Member;
import com.refactor.animals.beans.dto.LoginForm;
import com.refactor.animals.repository.MemoryMemberRepository;
import com.refactor.animals.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
    public boolean login(LoginForm loginForm) {
        LoginFormConverter loginFormConverter = new LoginFormConverter();
        Member memberDTO = loginFormConverter.converter(loginForm, encoder);
        Optional<Member> member = memoryMemberRepository.findMember(memberDTO.getLoginId());
        if(member.isPresent()){
            return true;
        }
        return false;
    }
    @Override
    public Member join(joinForm joinForm) {
        //encoder필요
        JoinFormConverter joinFormConverter = new JoinFormConverter();
        Member member = joinFormConverter.converter(joinForm, encoder);
        memoryMemberRepository.save(member);
        return member;
    }



    @Override
    public void updateUserInfo(Member member) {

    }

    @Override
    public boolean isLoginIdDuplicate(String checkId) {
        return memoryMemberRepository.findMember(checkId).isPresent();
    }
}
