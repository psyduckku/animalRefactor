package com.refactor.animals.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
public class JoinValidObjectList{
    private final List<JoinFormValidObject> err;

}
