package com.refactor.animals.controller;

import com.refactor.animals.beans.dto.JoinDTO;
import com.refactor.animals.beans.entity.Member;
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
    public String join(@Validated @ModelAttribute("member") JoinDTO joinDTO){
        //validation 실시


        //JoinDTO를 member setter(수정자)로 옮겨넣어줘야함(form 전송객체분리)
        //생성자에서 하자. 근데 여기서 생성자로하면 생성자에 넣어줘야할 인자값이 너무 많음.
        //Mapper로 하면된다는데, Mapper인터페이스이고, MapStruct는 규칙에 따라 코드를 생성하여 맵핑작업을한다..?
        //
//        Member member = new Member();


        return "/";
    }



}
