package com.refactor.animals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.ObjectError;

import java.util.Locale;

public class MessageSourceTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void MessageCodesResolverField(){
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "joinForm");
        for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }
        new ObjectError("joinForm",new String[]{"required.joinForm","required"},null,"미야옹");

    }
}
