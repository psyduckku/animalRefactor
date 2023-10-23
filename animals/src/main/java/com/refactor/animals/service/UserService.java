package com.refactor.animals.service;


import com.refactor.animals.beans.dto.JoinForm;
import com.refactor.animals.beans.entity.Member;
import com.refactor.animals.beans.dto.LoginForm;

import java.util.List;

public interface UserService {

    LoginForm login(LoginForm loginForm);
//    UserDTO getUserInfo(UserDTO userDTO);

    Member join(JoinForm joinForm);

    List<Member> memberList();

    boolean isLoginIdDuplicate(String id);
}
