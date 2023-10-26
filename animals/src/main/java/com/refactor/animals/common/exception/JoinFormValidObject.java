package com.refactor.animals.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
public class JoinFormValidObject {

    private String field;
    private String code;
    private String message;
    private String defaultMessage;

}
