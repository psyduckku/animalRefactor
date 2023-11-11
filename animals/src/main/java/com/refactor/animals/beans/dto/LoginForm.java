package com.refactor.animals.beans.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {
    String login_id;
    String password;

    public LoginForm(String login_id) {
        this.login_id = login_id;
    }
}
