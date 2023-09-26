package com.refactor.animals.beans.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@ToString
@NoArgsConstructor
@Setter @Getter
//@ScriptAssert(lang = "javascript", script="_this.address")
public class JoinForm {

    @NotNull

    @Size(min = 5, max = 15, message = "아이디는 5~20자 이내여야 합니다.")
    private String loginId;
    @NotNull
    @Size(min = 8, max = 20, message = "패스워드는 8~20자 이내여야 합니다.")
//    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).+$",
//            message = "패스워드는 영문, 숫자, 특수문자를 포함해야 합니다.")
    private String password;

    @NotNull
    private String confirmPassword;

    @NotBlank
    private String name;
    @NotNull
    private String nickName;
    @NotNull
//    @Size(min = 10, max = 11, message = "핸드폰 번호는 10~11자 이내여야 합니다.")
    @Pattern(regexp = "^[0-9]+$", message = "핸드폰 번호는 숫자만 입력해야 합니다.")
    private String phone;

    private String postcode; //생략가능
    private String address; //생략가능
    private String detailAddress; //생략가능
    private String extraAddress; //생략가능

}