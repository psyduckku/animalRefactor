package com.refactor.animals.service;


import com.refactor.animals.beans.dto.JoinForm;
import com.refactor.animals.beans.dto.Member;
import com.refactor.animals.beans.dto.LoginForm;

public interface UserService {

    boolean login(LoginForm loginForm);
//    UserDTO getUserInfo(UserDTO userDTO);

    Member join(JoinForm joinForm);

    void updateUserInfo(Member member);

    boolean isLoginIdDuplicate(String id);
}
