package com.refactor.animals.service;


import com.refactor.animals.dto.UserDTO;

public interface UserService {

    UserDTO login(String loginId, String password);
    UserDTO getUserInfo(UserDTO userDTO);
    void updateUserInfo(UserDTO userDTO);

}
