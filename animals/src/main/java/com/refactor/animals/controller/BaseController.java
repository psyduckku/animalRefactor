package com.refactor.animals.controller;

import com.refactor.animals.beans.dto.JoinForm;
import com.refactor.animals.beans.entity.MemberVO;
import com.refactor.animals.beans.dto.LoginForm;
import com.refactor.animals.service.serviceImpl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor //기본생성자 생성 private final이 여러개여도 기본생성자는 생성해줌(파라메터에 validator 등 여러개올수있으니)
@Controller
@RequestMapping("/base")  //getMapping에 /하나 안넣어서 개고생..
public class BaseController {

    /**
     * aano validation을 등록함에 따라 validator 객체 및 init바인더를 등록필요가 없음
     *
     */
    private final UserServiceImpl userService;
    private final String LOGIN_ID="loginId";

    @GetMapping("/")
    public String index(@SessionAttribute(name = LOGIN_ID, required=false) String loginId){

        log.info("index SessionAttribute member={}", loginId);

        return "index";
    }

    @GetMapping("/login")
    public String loginForm(HttpServletRequest request){

        String referer = request.getHeader("Referer");
        log.info("referer={}",referer);
        return "loginForm";
    }

//    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm loginFormDTO, BindingResult bindingResult, Model model,
                        @RequestParam(defaultValue="/") String redirectURL,
                        HttpServletRequest request){
        //로그인하였을 경우 model에 000님 반갑습니다. 나오도록
        //세션 추가
     //   userService.login(loginFormDTO.getLoginId(), loginFormDTO.getPassword());
        String uuid = UUID.randomUUID().toString();
        HttpSession session = request.getSession();
        session.setAttribute(uuid, loginFormDTO);

        model.addAttribute("welcome", "반갑습니다"); //얘를 모델말고 다른방법으로?
        return "redirect:" + redirectURL; //home으로 재호출하도록함. redirect가 아닌 form이동은 url이 변경되지않기때문.?
    }

    @GetMapping("/join")
    public String joinForm(Model model, HttpServletRequest request, HttpServletResponse response){
        Model redirectionCheck = model.addAttribute("joinForm", new JoinForm());
        log.info("redirectionCheck={}",redirectionCheck);
        String referer = request.getHeader("referer");
        log.info("referer={}", referer);
        String dispatcherType = String.valueOf(request.getDispatcherType());//Request인지, ERROR인지.. 등
        log.info("dispatcherType={}", dispatcherType);

        return "joinForm";
    }
    @PostMapping("/join")
    public String joinStringUtilsValidator(@Validated @ModelAttribute JoinForm joinForm, BindingResult bindingResult, Model model,
                                           HttpServletResponse response){
        /***
         * 회원가입 이후 이전 페이지 form을 날리는 방법 구현하기 interceptor로 ㄱ
         */

        if (bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);
            return "joinForm";
        }
        userService.join(joinForm);
        return "redirect:/base/login?welcome=welcome";
    }


    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }

        return "redirect:/";
    }
    @GetMapping("/memberList")
    public String memberList(){
        List<MemberVO> list = userService.memberList();
        log.info("list={}", list);
        return "redirect:/";
    }

    @RequestMapping("/adminPage")
    public String adminPage(){
        return "adminPage";
    }

    @RequestMapping("/findInfo")
    public String findInfo(){

        return "findInfo";
    }

    @GetMapping("/updatePage")
    public String updatePage(){

        return "animalApi";
    }


}
