package com.refactor.animals.controller.validator;

import com.refactor.animals.beans.dto.JoinForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Slf4j
@Component  //SpringBean등록
public class JoinDTOValidator implements org.springframework.validation.Validator {
    @Override
    public boolean supports(Class<?> clazz) {
//        log.info("clazz={}", clazz);
        return JoinForm.class.isAssignableFrom(clazz); //parameter로 넘어오는 클래스가 지원이 되냐.(자식클래스도 지원)
    }

    @Override
    public void validate(Object target, Errors errors) {
        JoinForm joinForm = (JoinForm) target;

        if(!StringUtils.hasText(joinForm.getLoginId()) || joinForm.getLoginId().length() < 5 ||
                joinForm.getLoginId().length() > 16){ //rejectValue 필드, reject 오브젝트
            errors.rejectValue("loginId", "required.loginId", new Object[]{5,15}, null);
        }
        if(!StringUtils.hasText(joinForm.getPassword())||
                joinForm.getPassword().length() < 7 || joinForm.getPassword().length() > 16){
            errors.rejectValue("password", "required.password", new Object[]{7,15}, null);
        }
        if(!StringUtils.hasText(joinForm.getNickname()) || joinForm.getNickname().length() < 2 ||
                joinForm.getNickname().length() > 10){
            errors.rejectValue("nickname","required.nickname",new Object[]{2, 7}, null);
        }



        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name", "name");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "phone");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "address");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "detailAddress", "detailAddress");



    }
}
