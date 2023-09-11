package com.refactor.animals.beans.converter;

import com.refactor.animals.beans.dto.Member;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class JoinFormConverter {
//얘내들은 회원가입시 회원가입 컨트롤러에서 사용될 예정임
    public final Member member;



    private static String getBeanNullCheck(String bean){
        return bean !=null ? bean : "none";
    }
    //class 객체만 넣으면 됨.
   // Member member = new Member();
}
