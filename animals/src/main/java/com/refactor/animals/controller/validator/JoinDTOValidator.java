package com.refactor.animals.controller.validator;

import com.refactor.animals.beans.dto.JoinFormDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Slf4j
@Component  //SpringBean등록
public class JoinDTOValidator implements org.springframework.validation.Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        log.info("clazz={}", clazz);
        return JoinFormDTO.class.isAssignableFrom(clazz); //parameter로 넘어오는 클래스가 지원이 되냐.(자식클래스도 지원)
    }

    @Override
    public void validate(Object target, Errors errors) {
        JoinFormDTO joinFormDTO = (JoinFormDTO) target;

        if(!StringUtils.hasText(joinFormDTO.getLoginId()) || joinFormDTO.getLoginId().length() < 5 ||
                joinFormDTO.getLoginId().length() > 16){ //rejectValue 필드, reject 오브젝트
            errors.rejectValue("loginId", "required", new Object[]{5,15}, "아이디 입력");
        }
        if(!StringUtils.hasText(joinFormDTO.getPassword())||
                joinFormDTO.getPassword().length() < 7 || joinFormDTO.getPassword().length() > 16){
            errors.rejectValue("password", "required", new Object[]{7,15}, "비밀번호 입력");
        }
        if(!StringUtils.hasText(joinFormDTO.getNickName()) || joinFormDTO.getNickName().length() < 2 ||
                joinFormDTO.getNickName().length() > 10){
            errors.rejectValue("nickName","required",new Object[]{2, 7}, "닉네임 입력");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name", "name");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "phone");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "address");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "detailAddress", "detailAddress");



    }
}
