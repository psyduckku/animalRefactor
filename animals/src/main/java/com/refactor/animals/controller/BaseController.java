package com.refactor.animals.controller;

import com.refactor.animals.beans.converter.JoinFormConverter;
import com.refactor.animals.beans.dto.JoinFormDTO;
import com.refactor.animals.beans.dto.Member;
import com.refactor.animals.beans.dto.UserLoginFormDTO;
import com.refactor.animals.common.UuidGenerator;
import com.refactor.animals.repository.MemoryMemberRepository;
import com.refactor.animals.service.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor //기본생성자 생성 private final이 여러개여도 기본생성자는 생성해줌(파라메터에 validator 등 여러개올수있으니)
@Controller
@RequestMapping("/base/member")  //getMapping에 /하나 안넣어서 개고생..
public class BaseController {

    /**
     * aano validation을 등록함에 따라 validator 객체 및 init바인더를 등록필요가 없음
     *
     */
    private final MemoryMemberRepository memoryMemberRepository;
    private final UserServiceImpl userService;
    private final UuidGenerator uuidGenerator;
    //생성자 하나에 여러 파라미터를 넣을 수 있음 생성자 하나에는 @AutoWired 생략가능
//    private final JoinDTOValidator joinDTOValidator;
    //컨트롤러가 요청될때마다 작동되며, 해당 클래스의 모든 메서드에 적용이 됨
//    @InitBinder
//    public void init(WebDataBinder dataBinder){
//        dataBinder.addValidators(joinDTOValidator);
//    }
    //하나의 컨트롤러에서만 작동됨. 글로벌하게 x.

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String loginForm(){
        log.info("loginForm");
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserLoginFormDTO loginFormDTO, BindingResult bindingResult, Model model){
        //로그인하였을 경우 model에 000님 반갑습니다. 나오도록
        userService.login(loginFormDTO.getLoginId(), loginFormDTO.getPassword());
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
    public String joinStringUtilsValidator(@Validated @ModelAttribute JoinFormDTO joinFormDTO, BindingResult bindingResult, Model model){

        //복합룰검증 추가 뭘로하지?
        if (bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);
            return "joinForm";
        }
        Member member = userService.join(joinFormDTO);

        log.info(member.getPassword());
        memoryMemberRepository.save(member);
        return "redirect:/base/member/login?welcome=welcome";
    }
    @ResponseBody
    @PostMapping("/isLoginIdDuplicate")
    public String isLoginIdDuplicate(@RequestBody String checkId){

        log.info("requestBody={}",checkId);
        String result = memoryMemberRepository.isLoginIdDuplicate(checkId);
        log.info("result={}", result);
        //여기서 분기 필요. result가 오류(404)가 나도 true를 보냄.


        return result;
    }
}
