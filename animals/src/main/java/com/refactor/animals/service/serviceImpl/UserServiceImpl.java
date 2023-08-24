package com.refactor.animals.service.serviceImpl;

import com.refactor.animals.dto.UserDTO;
import com.refactor.animals.repository.UserRepository;
import com.refactor.animals.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserDTO login(String loginId, String password) {
        return userRepository.findByLoginId(loginId)
                .filter(u -> u.getPassword().equals(password))
                .orElse(null);
    }

    @Override
    public UserDTO getUserInfo(UserDTO userDTO) {
        return
    }

    @Override
    public void updateUserInfo(UserDTO userDTO) {

    }
}
