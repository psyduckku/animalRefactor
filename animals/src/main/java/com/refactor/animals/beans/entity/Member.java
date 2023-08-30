package com.refactor.animals.beans.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Member {

//    @NotBlank
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private String address;
    private String nickName;
    private String phone;
    private String postcode;
    private String detailAddress;
    private String extraAddress; //생략가능

    public Member(Long id, String loginId, String password, String name, String address, String nickName, String phone, String postcode, String detailAddress, String extraAddress) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.address = address;
        this.nickName = nickName;
        this.phone = phone;
        this.postcode = postcode;
        this.detailAddress = detailAddress;
        this.extraAddress = extraAddress;
    }
}
