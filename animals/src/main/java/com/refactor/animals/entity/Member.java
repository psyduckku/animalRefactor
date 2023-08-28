package com.refactor.animals.entity;

import lombok.Data;

@Data
public class Member {

//    @NotBlank
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private String address;


}
