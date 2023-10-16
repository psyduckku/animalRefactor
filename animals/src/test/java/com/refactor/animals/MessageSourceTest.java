package com.refactor.animals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

public class MessageSourceTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void MessageCodesResolverField(){
       String[] messageCodes = codesResolver.resolveMessageCodes("loginId","joinFom","loginId",String.class);
        for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }

    }
}
