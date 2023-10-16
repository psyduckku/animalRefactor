package com.refactor.animals.controller;

import com.refactor.animals.beans.dto.JoinForm;
import com.refactor.animals.beans.dto.LoginForm;
import com.refactor.animals.beans.dto.Member;
import com.refactor.animals.service.serviceImpl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RequestMapping("/animal/api")
@RequiredArgsConstructor
@RestController //@ResponseBody + @Controller // 메서드에 ResponseBody안써도됨
public class ApiController {

    //return시 @RestController시에 반환하는 ResponseEntity의 차이.
    private final UserServiceImpl userService;
    private final MessageSource messageSource;

    @PostMapping("/login")            //RequestBody => mediaType이 application/json임(json요청만받는다)
    public String login(@RequestBody LoginForm loginForm, HttpServletRequest request) {
        String loginId = loginForm.getLoginId();
        String password = loginForm.getPassword();
        log.info("loginForm ={}", loginForm);
        boolean result = userService.login(loginForm);
        log.info("result={}", result);
        if (result) {
            HttpSession session = request.getSession(); //기본 true
            String sessionId = UUID.randomUUID().toString(); //기존 UuidGenerator클래스 사용x
            session.setAttribute("sessionId", sessionId); //세션 만료시간 추가하기
            log.info("sessionId={}", session.getAttribute("sessionId"));
            return "true";
        }

        return "false";
    }

    @PostMapping("/join")
    public Member join(@Valid @RequestBody JoinForm joinForm) {
        //bindingResult로 값 받아올 때랑...
        log.info("join controller");
        log.info("joinForm={}", joinForm.toString());
        Member member = userService.join(joinForm);

        return member;

//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(member.getId())
//                .toUri();
//        return ResponseEntity.created(location).build();

    }

}
