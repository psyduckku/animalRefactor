package com.refactor.animals.BCryptPasswordEncoder;

import com.refactor.animals.beans.converter.JoinFormConverter;
import com.refactor.animals.beans.dto.JoinForm;
import com.refactor.animals.beans.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BCryptPasswordEncoder {
    @Autowired
    private org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder encoder;

    @Test
    void encoderTest(){
        JoinForm joinForm = new JoinForm();
        JoinFormConverter joinFormConverter = new JoinFormConverter();
        joinForm.setLoginId("test1");
        joinForm.setPassword("qwe123");
        joinForm.setName("qwe123");
        joinForm.setNickname("test");
        joinForm.setAddress("test");
        joinForm.setPostcode("12345");
        joinForm.setDetailAddress("test");
        joinForm.setExtraAddress("test");

        Member member = joinFormConverter.converter(joinForm,encoder);
        //validator 어떻게 돌려야하지?

    }
}
