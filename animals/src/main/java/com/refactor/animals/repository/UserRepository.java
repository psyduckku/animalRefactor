package com.refactor.animals.repository;

import com.refactor.animals.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
public class UserRepository {

    private static Map<Long, UserDTO> store = new ConcurrentHashMap<>();
    private static long sequence = 0L; // static 사용
    public UserDTO save(UserDTO userDTO){
        userDTO.setId(++sequence);
        log.info("save: user={}", userDTO);
        return userDTO;
    }

    public Optional<UserDTO> findByLoginId(String password){
        return findAll().stream()
                .filter(u -> u.getPassword().equals(password))
                .findFirst();
    }

    public List<UserDTO> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
