package com.refactor.animals.BCryptPasswordEncoder;

import com.refactor.animals.beans.converter.JoinFormConverter;
import com.refactor.animals.beans.dto.JoinFormDTO;
import com.refactor.animals.beans.dto.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BCryptPasswordEncoder {
    @Autowired
    private org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder encoder;

    @Test
    void encoderTest(){
        JoinFormDTO joinFormDTO = new JoinFormDTO();
        JoinFormConverter joinFormConverter = new JoinFormConverter();
        joinFormDTO.setLoginId("test1");
        joinFormDTO.setPassword("qwe123");
        joinFormDTO.setName("qwe123");
        joinFormDTO.setNickName("test");
        joinFormDTO.setAddress("test");
        joinFormDTO.setPostcode("12345");
        joinFormDTO.setDetailAddress("test");
        joinFormDTO.setExtraAddress("test");

        Member member = joinFormConverter.convertToMemberDTO(joinFormDTO,encoder);
        //validator 어떻게 돌려야하지?

    }
}
