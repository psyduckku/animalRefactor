package com.refactor.animals.controller;

import com.refactor.animals.beans.dto.JoinForm;
import com.refactor.animals.beans.dto.LoginForm;
import com.refactor.animals.exception.UserException;
import com.refactor.animals.service.serviceImpl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RequestMapping("/animal/api")
@RequiredArgsConstructor
@RestController //@ResponseBody + @Controller // 메서드에 ResponseBody안써도됨
public class ApiController {
    private final UserServiceImpl userService;
    @PostMapping("/login")            //RequestBody => mediaType이 application/json임(json요청만받는다)
    public ResponseEntity<LoginForm> login(@RequestBody LoginForm loginForm, HttpServletRequest request) {

        LoginForm loginMember = userService.login(loginForm);
        //Service 로직에서 예외처리를 했기 때문에 Valid 불필요
        HttpSession session = request.getSession();
        String sessionId = UUID.randomUUID().toString(); // 따로 빼서 사용? . 얘 어케하지
        session.setAttribute("sessionId", sessionId); //세션 만료시간 추가하기

        return new ResponseEntity(loginMember, HttpStatus.OK);
    }

    @PostMapping("/join")
    public ResponseEntity<UserException> join(@Valid @RequestBody JoinForm joinForm) {
        log.info("joinForm={}", joinForm.toString());

        userService.join(joinForm);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/updateAnimals")
    public ResponseEntity updateAnimals(){
        log.info("updateAnimals");

        return new ResponseEntity(HttpStatus.OK);
    }


}
