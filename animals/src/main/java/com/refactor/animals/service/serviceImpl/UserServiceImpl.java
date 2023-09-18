package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.converter.JoinFormConverter;
import com.refactor.animals.beans.dto.JoinFormDTO;
import com.refactor.animals.beans.dto.Member;
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
    public boolean login(String loginId, String password) {
        //encoder필요
        //session 추가.
        //UUID만들기

               Optional<Member> member = memoryMemberRepository.findMember(loginId);
               if(member.isPresent()){
                   return password.equals(member.get().getPassword());
               }
               return false;
    }
    @Override
    public Member join(JoinFormDTO joinFormDTO) {
        //encoder필요
        JoinFormConverter joinFormConverter = new JoinFormConverter();
        Member member = joinFormConverter.convertToMemberDTO(joinFormDTO, encoder);
        return member;
    }

    @Override
    public void updateUserInfo(Member member) {

    }
}
