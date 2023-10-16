package com.refactor.animals.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class JoinValidJoinFormValidObject extends JoinFormValidObject {
    private final List<String> err;
}
