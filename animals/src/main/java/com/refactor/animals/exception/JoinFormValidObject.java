package com.refactor.animals.exception;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder //이거 빼니까 timestamp가 안됨.왜지?
public class JoinFormValidObject {

    private String title;
    private String code;
    private String rejectValue;
    private String message;

    public JoinFormValidObject(String title, String code, String rejectValue, String message) {
        this.title = title;
        this.code = code;
        this.rejectValue = rejectValue;
        this.message = message;
    }
}
