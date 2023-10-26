package com.refactor.animals.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginFormValidObject {
    private String code;
    private String message;

}
