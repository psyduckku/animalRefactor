package com.refactor.animals.beans.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

//Data 핵심 도메인에서 사용X
@NoArgsConstructor
@Getter @Setter
@ToString
@AllArgsConstructor
public class Member {

//    @NotBlank
    //회원가입시 id생성
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private String nickname;
    private String phone;
    private String address;
    private String postcode;
    private String detailAddress;
    private String extraAddress;
    /**
     * 회원가입 생성자
     * Address를 분리시켜 객체로 받고 싶지만, 일단 단순하게 가자.
     * 비즈니스 모델에 들어가는건 Entity임
     */
    public Member(String loginId, String password, String name, String nickname, String phone,
                  String address, String postcode, String detailAddress, String extraAddress)
    {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.phone = (phone!=null)?phone : "미기입";
        this.address = (address!=null)?address : "미기입";
        this.postcode = (postcode!=null)?postcode : "00000";
        this.detailAddress = (detailAddress!=null)?detailAddress:"미기입";
        this.extraAddress = (extraAddress!=null)?extraAddress:"미기입";
    }

    /**
     * 로그인 생성자
     * @param loginId
     * @param password
     */
    public Member(String loginId, String password){
        this.loginId = loginId;
        this.password = password;
    }



}
