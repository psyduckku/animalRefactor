package com.refactor.animals.service;


import com.refactor.animals.beans.dto.joinForm;
import com.refactor.animals.beans.dto.Member;
import com.refactor.animals.beans.dto.LoginForm;

public interface UserService {

    boolean login(LoginForm loginForm);
//    UserDTO getUserInfo(UserDTO userDTO);

    Member join(joinForm joinForm);

    void updateUserInfo(Member member);

    boolean isLoginIdDuplicate(String id);
}
