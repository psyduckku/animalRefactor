package com.refactor.animals.common.exception;

import com.refactor.animals.beans.dto.JoinForm;
import com.refactor.animals.common.exception.validator.JoinDTOValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionAdvice {


    @Qualifier("errorMessageSource")
    private final MessageSource messageSource;


    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationResult handleBindExcpetion(BindException bindException, Locale locale){
        return ValidationResult.create(bindException, messageSource,locale);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ResponseEntity<Object> joinFormException(MethodArgumentNotValidException argsNotValidException,
                                                    JoinForm joinForm, JoinDTOValidator joinDTOValidator, BindingResult bindingResult) {

        joinDTOValidator.validate(joinForm, bindingResult);
        log.info("bindingResult.getAllErrors={}",bindingResult.getAllErrors());


        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<LoginFormValidObject> loginFormException(){
        return new ResponseEntity(new LoginFormValidObject("loginForm.mismatch", "로그인 정보 불일치.")
                , HttpStatus.UNAUTHORIZED);
        //얘는 아이디 비밀번호 일치하는걸 서비스로직에서
        // 구현해야해서 추가적인 messageSource작업이 필요.
    }
}
