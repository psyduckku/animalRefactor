package com.refactor.animals.controller;

import com.refactor.animals.beans.dto.JoinForm;
import com.refactor.animals.beans.dto.LoginForm;
import com.refactor.animals.beans.dto.Member;
import com.refactor.animals.common.UuidGenerator;
import com.refactor.animals.controller.validator.JoinDTOValidator;
import com.refactor.animals.service.serviceImpl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j

@RequestMapping("/animal/api")
@RequiredArgsConstructor
@RestController //@ResponseBody + @Controller // 메서드에 ResponseBody안써도됨
public class ApiController {

    private final UserServiceImpl userService;
    private final JoinDTOValidator joinDTOValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder){
        dataBinder.addValidators(joinDTOValidator);
    }

    @PostMapping("/login")            //RequestBody => mediaType이 application/json임(json요청만받는다)
    public String login(@RequestBody LoginForm loginForm, HttpServletRequest request){
        String loginId = loginForm.getLoginId();
        String password = loginForm.getPassword();
        log.info("loginForm ={}", loginForm);
        boolean result = userService.login(loginForm);
        log.info("result={}", result);
        if(result==true){
            HttpSession session = request.getSession(); //기본 true
            String sessionId = UUID.randomUUID().toString(); //기존 UuidGenerator클래스 사용x
            session.setAttribute("sessionId", sessionId); //세션 만료시간 추가하기
            log.info("sessionId={}",session.getAttribute("sessionId"));
            return "true";
            }

        return "false";
    }

    @PostMapping("/join")
    public ResponseEntity join(@Validated @RequestBody JoinForm joinForm, BindingResult bindingResult){
        //1. join회원가입 버튼 클릭시 form데이터를 받아와야함
        //2. validation을 진행
        //3. errors에 담기
        //4. bindingResult.getAllErrors(), HttpStatus.Bad_Request 반환
        //    <-> HttpStatus.ok반환
        //5.
        joinDTOValidator.validate(joinForm, bindingResult);

        if(bindingResult.hasErrors()){
            log.info("errors={}", bindingResult);
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body("회원가입이 성공적으로 완료되었습니다.");
    }

}
