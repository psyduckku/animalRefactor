package com.refactor.animals.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@AllArgsConstructor(access= AccessLevel.PRIVATE)
public class ValidationResult {
    private List<FieldErrorDetail> errors;
    public static ValidationResult create(Errors errors, MessageSource messageSource, Locale locale){
        List<FieldErrorDetail> details =
                errors.getFieldErrors()
                        .stream()
                        .map(error -> FieldErrorDetail.create(error, messageSource, locale))
                        .collect(Collectors.toList());
        return new ValidationResult(details);
    }
}
