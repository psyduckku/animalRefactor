package com.refactor.animals.service;


import com.refactor.animals.beans.dto.JoinForm;
import com.refactor.animals.beans.entity.MemberVO;
import com.refactor.animals.beans.dto.LoginForm;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface UserService {

    LoginForm login(LoginForm loginForm);
//    UserDTO getUserInfo(UserDTO userDTO);

    HttpStatus join(JoinForm joinForm);

    List<MemberVO> memberList();

    boolean isLoginIdDuplicate(String id);
}
