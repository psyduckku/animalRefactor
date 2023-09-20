package com.refactor.animals.service;


import com.refactor.animals.beans.dto.joinForm;
import com.refactor.animals.beans.dto.Member;
import com.refactor.animals.beans.dto.loginForm;

public interface UserService {

    Member login(loginForm loginForm);
//    UserDTO getUserInfo(UserDTO userDTO);

    Member join(joinForm joinForm);

    void updateUserInfo(Member member);

    boolean isLoginIdDuplicate(String id);
}
