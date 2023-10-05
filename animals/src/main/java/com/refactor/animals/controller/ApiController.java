package com.refactor.animals.controller;

import com.refactor.animals.beans.dto.JoinForm;
import com.refactor.animals.beans.dto.LoginForm;
import com.refactor.animals.service.serviceImpl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j

@RequestMapping("/animal/api")
@RequiredArgsConstructor
@RestController //@ResponseBody + @Controller // 메서드에 ResponseBody안써도됨
public class ApiController {

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
    public Object join(@Validated @RequestBody JoinForm joinForm, BindingResult bindingResult) {
        //1. join회원가입 버튼 클릭시 form데이터를 받아와야함
        //2. validation을 진행
        //3. errors에 담기
        //4. bindingResult.getAllErrors(), HttpStatus.Bad_Request 반환
        //    <-> HttpStatus.ok반환
        //5. message를 다시 반환해야하는데 하;;
        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
//            Object[] argument = error.getArguments();
//            log.info("error={}",error);
//            log.info("argument={}",argument);
//            log.info(messageSource.getMessage("notNull", argument, Locale.getDefault()));
//            return messageSource.getMessage("notNull", argument, Locale.getDefault());
            return bindingResult.getAllErrors();
        }
        userService.join(joinForm);
        return joinForm;
    }

}
