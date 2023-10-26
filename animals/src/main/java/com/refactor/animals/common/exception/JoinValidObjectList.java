package com.refactor.animals.common.exception;

import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
public class JoinValidObjectList{
    private final List<JoinFormValidObject> err;

}
