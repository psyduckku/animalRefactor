package com.refactor.animals.beans.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
//@ScriptAssert(lang = "javascript", script="_this.address")
public class JoinForm {

//    @NotNull(message = "아이디를 입력해주세요")
//    @Size(min = 5, max = 15)
    private String login_id;
//    @NotNull(message="비밀번호를 입력해주세요")
//    @Size(min = 8, max = 20)
//    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).+$",
//            message = "패스워드는 영문, 숫자, 특수문자를 포함해야 합니다.")
    private String password;

//    @NotNull(message= "동일한 비밀번호를 입력해주세요")
//    @Size(min = 8, max=20)
    private String confirm_password;

//    @NotBlank(message="이름을 입력해주세요")
    private String name;
//    @NotNull(message= "닉네임을 입력해주세요")
//    @NotBlank(message = "닉네임을 입력해주세요")
    private String nickname;

//    @Size(min = 10, max = 11, message = "핸드폰 번호는 10~11자 이내여야 합니다.")
//    @Pattern(regexp = "^[0-9]+$", message = "핸드폰 번호는 숫자만 입력해야 합니다.")
//    @NotBlank
    private String phone;

    private String postcode; //생략가능
    private String address; //생략가능
    private String detail_address; //생략가능
    private String extra_address; //생략가능

}
