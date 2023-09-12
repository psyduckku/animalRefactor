package com.refactor.animals.service;


import com.refactor.animals.beans.dto.Member;

public interface UserService {

    boolean login(String loginId, String password);
//    UserDTO getUserInfo(UserDTO userDTO);
    void updateUserInfo(Member member);

}
