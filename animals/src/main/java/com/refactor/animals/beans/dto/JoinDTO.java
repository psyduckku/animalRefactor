package com.refactor.animals.beans.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class JoinDTO {

    @NotNull
    @Size(min = 5, max = 15, message = "아이디는 5~20자 이내여야 합니다.")
    private String loginId;
    @NotNull
    @Size(min = 8, max = 20, message = "패스워드는 8~20자 이내여야 합니다.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).+$",
            message = "패스워드는 영문, 숫자, 특수문자를 포함해야 합니다.")
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String nickName;
    @NotNull
    @Size(min = 10, max = 11, message = "핸드폰 번호는 10~11자 이내여야 합니다.")
    @Pattern(regexp = "^[0-9]+$", message = "핸드폰 번호는 숫자만 입력해야 합니다.")
    private String phone;

    @NotNull
    private String postcode;

    @NotNull
    private String address;
    @NotNull
    private String detailAddress;
    private String extraAddress; //생략가능

    public JoinDTO(String loginId, String password, String name, String nickName, String phone, String postcode, String address, String detailAddress, String extraAddress) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.phone = phone;
        this.postcode = postcode;
        this.address = address;
        this.detailAddress = detailAddress;
        this.extraAddress = extraAddress;  //Optional사용..?
    }
}
