package com.refactor.animals.service;


import com.refactor.animals.beans.dto.JoinFormDTO;
import com.refactor.animals.beans.dto.Member;

public interface UserService {

    boolean login(String loginId, String password);
//    UserDTO getUserInfo(UserDTO userDTO);

    Member join(JoinFormDTO joinFormDTO);

    void updateUserInfo(Member member);
}
