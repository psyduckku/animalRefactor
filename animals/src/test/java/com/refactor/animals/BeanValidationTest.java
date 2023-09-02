package com.refactor.animals;

import com.refactor.animals.beans.dto.JoinFormDTO;
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

        JoinFormDTO dto = new JoinFormDTO();

        dto.setLoginId("paulk");
        dto.setPassword("123");
        dto.setName(" ");
        dto.setPhone("010-6778-5505");
        dto.setNickName("hi");
        dto.setPostcode("15342");
        dto.setAddress("경기도 용인시");
        dto.setDetailAddress("신갈123");
        dto.setExtraAddress("aiejf");

        Set<ConstraintViolation<JoinFormDTO>> violations = validator.validate(dto);
        for (ConstraintViolation<JoinFormDTO> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
        }
    }
}
