package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.dto.Member;
import com.refactor.animals.repository.MemoryMemberRepository;
import com.refactor.animals.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final MemoryMemberRepository memoryMemberRepository;


    //optional이 있는 값을 반환하려면 get()이 필요.
    //또한 get()사용하기전에 isPresent()로 값이 있는지 확인이 필요
    @Override
    public boolean login(String loginId, String password) {
               Optional<Member> member = memoryMemberRepository.findMember(loginId);
               if(member.isPresent()){
                   return password.equals(member.get().getPassword());
               }
               return false;
    }
//    @Override
//    public UserDTO getUserInfo(UserDTO userDTO) {
//        return userRepository.findAll();
//    }

    @Override
    public void updateUserInfo(Member member) {

    }
}
