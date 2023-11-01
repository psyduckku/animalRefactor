package com.refactor.animals.common.exception.advice;

import com.refactor.animals.common.exception.JoinFormValidObject;
import com.refactor.animals.common.exception.LoginFormValidObject;
import com.refactor.animals.common.exception.UserException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionAdvice {


    private final MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ResponseEntity<Object> joinFormException(MethodArgumentNotValidException argsNotValidException,
                                                  BindingResult bindingResult) {
        List<JoinFormValidObject> list = new ArrayList<>(); //얘 따로 빼고, concurrent같은 멀티쓰레딩 지원되는애로 교체할것
        log.info("exceptionAdvice err={}", bindingResult.getFieldErrors());
        for(FieldError err : bindingResult.getFieldErrors()){
            String errors = messageSource.getMessage(err.getCode(), null, Locale.KOREA);
            log.info("errors={}",errors);
            JoinFormValidObject joinObject = new JoinFormValidObject(err.getField(), err.getCode(), errors, err.getDefaultMessage() );
            list.add(joinObject);
        }
        return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<LoginFormValidObject> loginFormException(){
        return new ResponseEntity(new LoginFormValidObject("loginForm.mismatch", "로그인 정보 불일치.")
                , HttpStatus.UNAUTHORIZED);
        //얘는 아이디 비밀번호 일치하는걸 서비스로직에서
        // 구현해야해서 추가적인 messageSource작업이 필요.
    }

}
