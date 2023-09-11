package com.refactor.animals.beans.dto;

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
    private String nickName;
    private String phone;
    private AddressDTO addressDTO;
    /**
     * 회원가입 생성자
     */
    public Member(Long id, String loginId, String password, String name, String nickName, String phone, AddressDTO addressDTO) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.phone = phone;
        this.addressDTO = new AddressDTO(
            addressDTO.getAddress(),
            addressDTO.getPostcode(),
            addressDTO.getDetailAddress(),
            addressDTO.getExtraAddress()
        );
    }

}
