package com.refactor.animals.common;


import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidGenerator {

    public String createId(){
        return UUID.randomUUID().toString();
    }

}
