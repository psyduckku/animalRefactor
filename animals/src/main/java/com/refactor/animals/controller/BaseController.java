package com.refactor.animals.controller;

import com.refactor.animals.beans.converter.JoinFormConverter;
import com.refactor.animals.beans.dto.JoinFormDTO;
import com.refactor.animals.beans.dto.Member;
import com.refactor.animals.repository.MemoryMemberRepository;
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
@RequestMapping("/base")  //시발!!! getMapping에 /하나 안넣어서 개고생..
public class BaseController {

    /**
     * aano validation을 등록함에 따라 validator 객체 및 init바인더를 등록필요가 없음
     * @return
     */
    private final MemoryMemberRepository memoryMemberRepository;
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
    public String joinStringUtilsValidator(@Validated @ModelAttribute JoinFormDTO joinFormDTO, BindingResult bindingResult, Model model){

        //복합룰검증 만들기. .reject로.. (.rejectValue는 필드검증
//        if(!StringUtils.hasText(joinFormDTO.getAddress())){
//            bindingResult.reject("addressIsNull");
//        }
        if (bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);
            return "joinForm";
        }
        log.info("joinFormDTO={}",joinFormDTO);

        JoinFormConverter joinFormConverter = new JoinFormConverter();

        Member member = joinFormConverter.convertToMemberDTO(joinFormDTO);

        log.info("member={}", member);

        memoryMemberRepository.save(member);
        log.info("memberRepository.findAll={}", memoryMemberRepository.findAll());

        return "loginForm";
    }
}
