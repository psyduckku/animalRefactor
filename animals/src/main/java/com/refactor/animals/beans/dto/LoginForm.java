package com.refactor.animals.beans.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {
    String loginId;
    String password;

    public LoginForm(String loginId) {
        this.loginId = loginId;
    }
}
