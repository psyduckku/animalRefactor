package com.refactor.animals.repository;

import com.refactor.animals.beans.dto.Member;
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

    private static final Map<Long, Member> store = new ConcurrentHashMap<>();
    private static long sequence = 0L; // static 사용
    public Member save(Member member){
        member.setId(++sequence);
        log.info("save: user={}", member);
        return member;
    }

    public Optional<Member> findByLoginId(String password){
        return findAll().stream()
                .filter(u -> u.getPassword().equals(password))
                .findFirst();
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

//    public UserDTO getUserInfo(String loginId, String password){
//
////        return
//    }

    public void clearStore(){
        store.clear();
    }

}
