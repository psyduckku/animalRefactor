package com.refactor.animals.exception.advice;

import com.refactor.animals.exception.JoinFormValidObject;
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

import javax.mail.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ResponseEntity<Object> joinFormException(MethodArgumentNotValidException argsNotValidException,
                                                  BindingResult bindingResult) {
        List<JoinFormValidObject> list = new ArrayList<>();
        for(FieldError err : bindingResult.getFieldErrors()){
            String errors = messageSource.getMessage(err.getCode(), null, Locale.KOREA);
            log.info("errors={}",errors);
            JoinFormValidObject joinObject = new JoinFormValidObject(err.getField(), err.getCode(), errors, err.getDefaultMessage() );
            list.add(joinObject);
        }
        return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST
        );
    }
}
