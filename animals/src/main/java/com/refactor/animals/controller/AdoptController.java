package com.refactor.animals.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/adopt")
public class AdoptController {

    @RequestMapping("/admin")
    public String adminPage(HttpSession session){
        //세션 확인. 권한 설정 . 확인


        return "adminPage";
    }


}
