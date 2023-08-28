package com.refactor.animals.service;


import com.refactor.animals.entity.Member;

public interface UserService {

    Member login(String loginId, String password);
//    UserDTO getUserInfo(UserDTO userDTO);
    void updateUserInfo(Member member);

}
