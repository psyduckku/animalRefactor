package com.refactor.animals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.ObjectError;

import java.util.Locale;

@SpringBootTest
public class MessageSourceTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();
    @Autowired
    private MessageSource messageSource;

    @Test
    void MessageCodesResolverField(){
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "joinForm");
        for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }
        new ObjectError("joinForm",new String[]{"required.joinForm","required"},null,"미야옹");
    }

    @Test
    void MessageSourcesTest(){
            String message = messageSource.getMessage("field.length",null,Locale.getDefault());
        System.out.println("message = " + message);
        }


}
