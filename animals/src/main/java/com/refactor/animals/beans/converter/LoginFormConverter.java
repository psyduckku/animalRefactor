package com.refactor.animals.beans.converter;

import com.refactor.animals.beans.dto.Member;
import com.refactor.animals.beans.dto.LoginForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
public class LoginFormConverter {

    public Member converter(LoginForm loginForm, BCryptPasswordEncoder encoder){
        return new Member(loginForm.getLoginId(), encoder.encode(loginForm.getPassword()));


    }

}