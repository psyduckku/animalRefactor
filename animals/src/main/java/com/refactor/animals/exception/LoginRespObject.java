package com.refactor.animals.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class LoginRespObject {
    private String code;
    private String message;
    private HttpStatus status;

}
