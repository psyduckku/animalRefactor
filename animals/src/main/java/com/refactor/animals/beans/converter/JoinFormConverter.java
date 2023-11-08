package com.refactor.animals.beans.converter;

import com.refactor.animals.beans.dto.JoinForm;
import com.refactor.animals.beans.entity.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


// 해당 Converter에 어떻게 값을 넣고 Member에 담을 것인가.

@Slf4j
//@NoArgsConstructor
public class JoinFormConverter {

    public MemberVO converter(JoinForm joinForm, BCryptPasswordEncoder encoder){
        return new MemberVO(joinForm.getLogin_id(),
                 encoder.encode(joinForm.getPassword()),
                joinForm.getName(),
                joinForm.getNickname(),
                joinForm.getPhone(),
                joinForm.getAddress(),
                joinForm.getPostcode(),
                joinForm.getDetail_address(),
                joinForm.getExtra_address()
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
