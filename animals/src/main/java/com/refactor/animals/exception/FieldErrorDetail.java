package com.refactor.animals.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.context.MessageSource;
import org.springframework.validation.FieldError;

import java.util.Locale;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Value
public class FieldErrorDetail {

    private String objectName;
    private String field;
    private String code;
    private String message;

    @Builder
    public static FieldErrorDetail create(FieldError fieldError, MessageSource messageSource, Locale locale){
        return new FieldErrorDetail(
                fieldError.getObjectName(), fieldError.getField(),
                fieldError.getCode(), messageSource.getMessage(fieldError,locale));
    }


}
