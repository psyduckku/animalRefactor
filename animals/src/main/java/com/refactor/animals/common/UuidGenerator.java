package com.refactor.animals.common;


import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidGenerator {

    public String generateSessionId(){
        return UUID.randomUUID().toString();
    }

}
