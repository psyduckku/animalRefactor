package com.refactor.animals.controller;

import com.refactor.animals.beans.dto.JoinFormDTO;
import com.refactor.animals.controller.validator.JoinDTOValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor //기본생성자 생성 private final이 여러개여도 기본생성자는 생성해줌(파라메터에 validator 등 여러개올수있으니)
@Controller
@RequestMapping("/base")  //시발!!! getMapping에 /하나 안넣어서 개고생..
public class BaseController {

    //생성자 하나에 여러 파라미터를 넣을 수 있음 생성자 하나에는 @AutoWired 생략가능
    private final JoinDTOValidator joinDTOValidator;


    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(Model model){
        //로그인하였을 경우 model에 000님 반갑습니다. 나오도록
        model.addAttribute("welcome", "반갑습니다");

        return "index";
    }

    @GetMapping("/join")
    public String joinForm(Model model){
        log.info("회원가입창 이동");
        model.addAttribute("joinFormDTO", new JoinFormDTO());
        //검증 실패시 form의 object, field 데이터를 담아서 다시 뿌려줌
        return "joinForm";
    }
    @PostMapping("/join")
    public String joinStringUtilsValidator(@ModelAttribute JoinFormDTO joinFormDTO, BindingResult bindingResult, Model model){
        //StringUtils을 사용한 회원가입
        //Map을 만들기
        //@Validated annotation이 있어서 오류로 빠졌음

        if(joinDTOValidator.supports(joinFormDTO.getClass())){
            joinDTOValidator.validate(joinFormDTO, bindingResult);  //target, bindingResult
        }
        if (bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);
            return "joinForm";
        }
        log.info("joinFormDTO={}",joinFormDTO);
        return "joinForm";
    }
}
