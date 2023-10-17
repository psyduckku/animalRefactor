package com.refactor.animals.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
public class JoinFormValidObject {

    private String field;
    private String code;
    private String message;
    private String defaultMessage;

    public JoinFormValidObject(String field, String code, String message, String defaultMessage) {
        this.field = field;
        this.code = code;
        this.message = message;
        this.defaultMessage = defaultMessage;

    }
}
