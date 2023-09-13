package com.refactor.animals.beans.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

//Data 핵심 도메인에서 사용X
@NoArgsConstructor
@Getter @Setter
public class Member {

//    @NotBlank
    //회원가입시 id생성
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private String nickName;
    private String phone;
    private String address;
    private String postcode;
    private String detailAddress;
    private String extraAddress;
    /**
     * 회원가입 생성자
     * Address를 분리시켜 객체로 받고 싶지만, 일단 단순하게 가자.
     */
    public Member(String loginId, String password, String name, String nickName, String phone,
                  String address, String postcode, String detailAddress, String extraAddress)
    {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.phone = (phone!=null)?phone : "미기입";
        this.address = (address!=null)?address : "미기입";
        this.postcode = (postcode!=null)?postcode : "00000";
        this.detailAddress = (detailAddress!=null)?detailAddress:"미기입";
        this.extraAddress = (extraAddress!=null)?extraAddress:"미기입";
    }

}
