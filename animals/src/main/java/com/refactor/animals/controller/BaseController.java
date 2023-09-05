package com.refactor.animals.controller;

import com.refactor.animals.beans.dto.JoinFormDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/base")  //시발!!! getMapping에 /하나 안넣었다고 이지랄!!
public class BaseController {

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

//        log.info("joinFormDTO.getLoginId() = {}",joinFormDTO.getLoginId());
        //ConcurrentHashMap은 나중에 쓰기
        if(!StringUtils.hasText(joinFormDTO.getLoginId()) || joinFormDTO.getLoginId().length() < 5 ||
            joinFormDTO.getLoginId().length() > 16){
            bindingResult.addError(new FieldError("joinFormDTO", "loginId", joinFormDTO.getLoginId(),
                    false, null, null,"아이디는 5자 이상 15자 이내로 작성해주세요"));
        }
        if(!StringUtils.hasText(joinFormDTO.getPassword())||
                joinFormDTO.getPassword().length() < 7 || joinFormDTO.getPassword().length() > 16){
            bindingResult.addError(new FieldError("joinFormDTO", "password", joinFormDTO.getPassword(),
                    false, null, null, "비밀번호는 7자 이상 또는 15자 이내로 입력해주세요"));
        }
        if(!StringUtils.hasText(joinFormDTO.getNickName()) || joinFormDTO.getNickName().length() < 2 ||
                joinFormDTO.getNickName().length() > 10){
            bindingResult.addError(new FieldError("joinFormDTO", "nickName", joinFormDTO.getNickName(),
                    false, null, null, "닉네임은 2자 이상 10자 이내로 입력하세요"));
        }
        if(!StringUtils.hasText(joinFormDTO.getName())){
            bindingResult.addError(new FieldError("joinFormDTO", "name", joinFormDTO.getName(),
                    false, null, null, "이름을 입력해주세요."));
        }
        if(!StringUtils.hasText(joinFormDTO.getPhone())){
            bindingResult.addError(new FieldError("joinFormDTO", "phone", joinFormDTO.getPhone(),
                    false, null, null, "핸드폰번호를 입력해주세요"));
        }
        if(!StringUtils.hasText(joinFormDTO.getAddress())){
            bindingResult.addError(new FieldError("joinFormDTO", "address", joinFormDTO.getAddress(),
                    false, null, null, "주소를 입력해주세요"));
        }
        if (!StringUtils.hasText(joinFormDTO.getDetailAddress())) {
            bindingResult.addError(new FieldError("joinFormDTO","detailAddress", joinFormDTO.getDetailAddress(),
                    false, null, null, "상세주소를 입력해주세요"));
        }

        //검증실패시 errors정보를 담아 회원가입창으로 재이동
        if (bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);
            return "joinForm";
        }
        log.info("joinFormDTO={}",joinFormDTO);

        return "joinForm";
    }



}
