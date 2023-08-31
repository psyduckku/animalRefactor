package com.refactor.animals.controller;

import com.refactor.animals.beans.dto.JoinFormDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/base")
public class BaseController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model){
        //로그인하였을 경우 model에 000님 반갑습니다. 나오도록
        model.addAttribute("welcome", "반갑습니다");

        return "/";
    }

    @GetMapping("/join")
    public String joinForm(){
        return "join";
    }
    @PostMapping("/join")
    public String join(@Validated @ModelAttribute("member") JoinFormDTO joinFormDTO){
        //validation 실시


        //dto를 entity로 변환시키기(변환시 joinDto, joinEntity 개별 클래스로 넣어주자)
        //여기서 form dto validtion 검증 후 error발견시 빠꾸시키기
        //근데 애초에 값이 컨트롤러로 넘어오기전에 클라이언트에서 해당 값을 입력 못하게(특수문자같은)
        //처리하고 마지막으로 컨트롤러에서 validation 작업을 하는게 좋을 것 같다.
        //

//        Member member = new Member();


        return "/";
    }



}
