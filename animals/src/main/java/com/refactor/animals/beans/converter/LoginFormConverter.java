package com.refactor.animals.beans.converter;

import com.refactor.animals.beans.dto.LoginForm;
import com.refactor.animals.beans.entity.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
public class LoginFormConverter {
//encoding해줄필요 없음 일치여부 .matches로 하면됨
    public MemberVO converter(LoginForm loginForm){
        return new MemberVO(loginForm.getLogin_id(), loginForm.getPassword());

    }

}
