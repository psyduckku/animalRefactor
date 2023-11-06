package com.refactor.animals.common.exception.validator;

import com.refactor.animals.beans.dto.JoinForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Slf4j
@Component  //SpringBean등록
public class JoinDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
//        log.info("clazz={}", clazz);
        return JoinForm.class.isAssignableFrom(clazz); //parameter로 넘어오는 클래스가 지원이 되냐.(자식클래스도 지원)
    }

    @Override
    public void validate(Object target, Errors errors) {
        JoinForm joinForm = (JoinForm) target;

        if(!StringUtils.hasText(joinForm.getLogin_id())) { //rejectValue 필드, reject 오브젝트
            errors.rejectValue("loginId", "field.required", null, "아이디를 입력해주세요");
        }else if(joinForm.getLogin_id().length() < 5 ||
                joinForm.getLogin_id().length() > 12){
            errors.rejectValue("loginId", "field.length", new Object[]{5, 12}, "5 ~ 12자 이내로 입력해주세요");
        }
        if(!StringUtils.hasText(joinForm.getPassword())||
                joinForm.getPassword().length() < 7 || joinForm.getPassword().length() > 16){
            errors.rejectValue("password", "field.length", new Object[]{7,15}, null);
        }
        if(!StringUtils.hasText(joinForm.getNickname()) || joinForm.getNickname().length() < 2 ||
                joinForm.getNickname().length() > 10){
            errors.rejectValue("nickname","filed.length",new Object[]{2, 7}, null);
        }

        if(!StringUtils.hasText(joinForm.getName())){
            errors.rejectValue("name","field.required", "이름을 입력해주세요");
        }else if(joinForm.getName().matches("^[가-힣]*$")){
            errors.rejectValue("name", "field.matches", "한글을 입력해주세요");
        }

        if(!StringUtils.hasText(joinForm.getPhone())){
            errors.rejectValue("phone", "field.required", "핸드폰 번호를 입력해주세요");
        }else if(!joinForm.getPhone().matches("^[0-9]+$")){
            errors.rejectValue("phone", "field.matches","숫자 이외에는 입력할 수 없습니다.");
        }

    }
}
