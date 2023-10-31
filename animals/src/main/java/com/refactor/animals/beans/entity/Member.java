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
    private String login_id;
    private String password;
    private String update_info_password;
    private String name;
    private String nickname;
    private String phone;
    private String address;
    private String postcode;
    private String detail_address;
    private String extra_address;

    private String access_time;
    private String access_ip;
    private String browser;
    private String withdrawal_date;

    private String grade;

    /**
     * 회원가입 생성자
     * Address를 분리시켜 객체로 받고 싶지만, 일단 단순하게 가자.
     * 비즈니스 모델에 들어가는건 Entity임
     */
    public Member(String login_id, String password, String name,
                  String nickname, String phone, String address,
                  String postcode, String detail_address, String
                  extra_address) {
        this.login_id = login_id;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.phone = phone;
        this.address = address;
        this.postcode = postcode;
        this.detail_address = detail_address;
        this.extra_address = extra_address;
    }

    /**
     * 로그인 생성자
     * @param login_id
     * @param password
     */
    public Member(String login_id, String password){
        this.login_id = login_id;
        this.password = password;
    }



}
