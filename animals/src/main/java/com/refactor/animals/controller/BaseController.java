package com.refactor.animals.controller;

import com.refactor.animals.beans.dto.JoinFormDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model){
        //로그인하였을 경우 model에 000님 반갑습니다. 나오도록
        model.addAttribute("welcome", "반갑습니다");

        return "/";
    }

    @GetMapping("/join")
    public String joinForm(@ModelAttribute JoinFormDTO joinFormDTO){
        log.info("회원가입창 이동");
        log.info("joinFormDTO.getLoginId={}", joinFormDTO.getLoginId());
        return "join";
    }
    @PostMapping("/join")
    public String joinStringUtilsValidator(@Validated @ModelAttribute JoinFormDTO joinFormDTO){
        //StringUtils을 사용한 회원가입
        //Map을 만들기

        log.info("joinFormDTO.getLoginId() = {}",joinFormDTO.getLoginId());


        //ConcurrentHashMap은 나중에 쓰기
//        Map<String, String> errors = new HashMap<>();
//        if(!StringUtils.hasText(joinFormDTO.getLoginId())){
//            errors.put("loginId", "사용하실 아이디를 입력해주세요");
//        }
//        if(joinFormDTO.getPassword()==null ||
//                joinFormDTO.getPassword().length() < 7 || joinFormDTO.getPassword().length() > 15){
//            errors.put("password", "비밀번호는 7자 이상 또는 15자 이하로 입력해주세요");
//        }
//        if(joinFormDTO.getName()==null){
//            errors.put("name", "이름을 입력해주세요.");
//        }
//        if(joinFormDTO.getPhone()==null){
//            errors.put("phone", "핸드폰번호를 입력해주세요");
//        }
//        if(joinFormDTO.getAddress()==null){
//            errors.put("address", "주소를 입력해주세요.");
//        }
//        if (joinFormDTO.getDetailAddress()==null) {
//            errors.put("detailAddress", "상세주소를 입력해주세요");
//        }
//
//        //검증실패시 errors정보를 담아 회원가입창으로 재이동
//        if (!errors.isEmpty()) {
//            model.addAttribute("errors", errors);
//            log.info("errors = {}", errors);
//            return "/base/join";
//        }


        return "join";
    }



}
