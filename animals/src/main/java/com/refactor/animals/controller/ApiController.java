package com.refactor.animals.controller;

import com.refactor.animals.beans.dto.LoginForm;
import com.refactor.animals.beans.dto.Member;
import com.refactor.animals.service.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@Slf4j

@RequestMapping("/animal/api")
@RequiredArgsConstructor
@RestController //@ResponseBody + @Controller // 메서드에 ResponseBody안써도됨
public class ApiController {

    private final UserServiceImpl userService;

    @PostMapping("/login")
    public String login(@RequestBody LoginForm loginForm){
        String loginId = loginForm.getLoginId();
        String password = loginForm.getPassword();
        log.info("loginForm ={}", loginForm);
        boolean result = userService.login(loginForm);
        log.info("result={}", result);
        if(result==true){
            return "true";
        }
        return "false";
    }

}
