package com.refactor.animals.beans.converter;

import com.refactor.animals.beans.dto.AddressDTO;
import com.refactor.animals.beans.dto.JoinFormDTO;
import com.refactor.animals.beans.dto.Member;


// 해당 Converter에 어떻게 값을 넣고 Member에 담을 것인가.
public class JoinFormConverter {

    public Member convertToMemberDTO(JoinFormDTO joinFormDTO){
        return new Member(joinFormDTO.getLoginId(),
                joinFormDTO.getPassword(),
                joinFormDTO.getName(),
                joinFormDTO.getNickName(),
                joinFormDTO.getPhone(),
                joinFormDTO.getAddress(),
                joinFormDTO.getPostcode(),
                joinFormDTO.getDetailAddress(),
                joinFormDTO.getExtraAddress()
        );
    }

//얘내들은 회원가입시 회원가입 컨트롤러에서 사용될 예정임
//    Member member = new Member();


    private static String getBeanNullCheck(String bean){
        return bean !=null ? bean : "none";
    }
    //class 객체만 넣으면 됨.
   // Member member = new Member();
}
