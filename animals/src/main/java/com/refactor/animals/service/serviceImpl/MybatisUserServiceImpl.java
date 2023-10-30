package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.beans.dto.JoinForm;
import com.refactor.animals.beans.dto.LoginForm;
import com.refactor.animals.beans.entity.Member;
import com.refactor.animals.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
//@Service
public class MybatisUserServiceImpl implements UserService {

    @Override
    public LoginForm login(LoginForm loginForm) {
        return null;
    }

    @Override
    public Member join(JoinForm joinForm) {
        return null;
    }

    @Override
    public List<Member> memberList() {
        return null;
    }

    @Override
    public boolean isLoginIdDuplicate(String id) {
        return false;
    }
}
