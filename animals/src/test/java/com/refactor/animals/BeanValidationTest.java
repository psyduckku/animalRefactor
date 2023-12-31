package com.refactor.animals;

import com.refactor.animals.beans.dto.JoinForm;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class BeanValidationTest {

    @Test
    void beanValidation(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        JoinForm dto = new JoinForm();

        dto.setLogin_id("paulk");
        dto.setPassword("123");
        dto.setName(" ");
        dto.setPhone("010-6778-5505");
        dto.setNickname("hi");
        dto.setPostcode("15342");
        dto.setAddress("경기도 용인시");
        dto.setDetail_address("신갈123");
        dto.setExtra_address("aiejf");

        Set<ConstraintViolation<JoinForm>> violations = validator.validate(dto);
        for (ConstraintViolation<JoinForm> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
        }
    }
}
