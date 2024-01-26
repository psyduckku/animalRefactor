package com.refactor.animals.beans.entity;

import lombok.*;

import java.util.Date;

//Data 핵심 도메인에서 사용X
@NoArgsConstructor
@Getter @Setter
@ToString
@AllArgsConstructor
public class MemberVO {

//    @NotBlank
    //회원가입시 id생성
    private Long id;
    private String login_id;
    private String password;
    private String update_info_password;
    private String name;
    private String nickname;
    private String address;
    private String postcode;
    private String detail_address;
    private String extra_address;

    private Date access_time;
    private String access_ip;
    private String browser;
    private String withdrawal_date;
    private String grade;
    private String phone;
    private String email;

    /**
     * 회원가입 생성자
     * Address를 분리시켜 객체로 받고 싶지만, 일단 단순하게 가자.
     * 비즈니스 모델에 들어가는건 Entity임
     */
    public MemberVO(String login_id, String password, String name,
                    String nickname, String phone, String address,
                    String postcode, String detail_address, String
                  extra_address, String email) {
        this.login_id = login_id;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.phone = phone;
        this.address = address;
        this.postcode = postcode;
        this.detail_address = detail_address;
        this.extra_address = extra_address;
        this.email = email;
    }

    /***
     * 로그인 convert용 생성자
     * @param login_id
     * @param password
     */
    public MemberVO(String login_id, String password) {
        this.login_id = login_id;
        this.password = password;
    }

    /****로그인정보반환
     *
     * @param id
     * @param login_id
     * @param update_info_password
     * @param nickname
     * @param access_time
     * @param access_ip
     * @param browser
     */
    public MemberVO(Long id, String login_id, String update_info_password, String nickname, Date access_time, String access_ip, String browser, String grade) {
        this.id = id;
        this.login_id = login_id;
        this.update_info_password = update_info_password;
        this.nickname = nickname;
        this.access_time = access_time;
        this.access_ip = access_ip;
        this.browser = browser;
        this.grade = grade;
    }
}
