package com.refactor.animals.exception;

import lombok.*;
import org.springframework.context.MessageSource;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.Locale;


@Getter
@NoArgsConstructor
@ToString
public class ErrorResult {

    private List<FieldErrorDetail> fieldErrorDetails;

    @Builder
    public ErrorResult(Errors errors, MessageSource messageSource, Locale locale){
        this.fieldErrorDetails = errors.getFieldErrors()
                .stream()
                .map(error ->
                        FieldErrorDetail.builder() // d
                                .fieldError(error)
                                .messageSource(messageSource)
                                .locale(locale)
                                .build()
                ).toList();
    }
}
