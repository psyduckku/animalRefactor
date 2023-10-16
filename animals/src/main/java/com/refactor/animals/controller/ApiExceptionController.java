package com.refactor.animals.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController //restController이기 때문에 text/html요청시 ex가 아닌 다른 id를 요청시 406에러를 반환함//
//WebServerCustomizer를 등록하고 text/html로 ex를 요청할경우. 등록한 error-page/500가 반환됨
//WebServerCustomizer를 해제하고 text/html로 aa 요청시 /error를 호출 및 406에러가 뜨며, 오류페이지 error에 404로 등록되어있어서
// 오류페이지가 white label이 나오는듯. error경로에 4xx로 바꾸니까 해당 4xx페이지를 환함.
//api로 ex요청시 logInterceptor에서 postHanlder[null] 이며, 뷰반환없음
//결론적으론 api ex요청시 뷰반환은 없다는것..
public class ApiExceptionController {
    public static final String ERROR_EXCEPTION = "jakarta.servlet.error.exception";
    public static final String ERROR_EXCEPTION_TYPE = "jakarta.servlet.error.exception_type";
    public static final String ERROR_MESSAGE = "jakarta.servlet.error.message";
    public static final String ERROR_REQUEST_URI = "jakarta.servlet.error.request_uri";
    public static final String ERROR_SERVLET_NAME = "jakarta.servlet.error.servlet_name";
    public static final String ERROR_STATUS_CODE = "jakarta.servlet.error.status_code";


    @GetMapping("/api/members/{id}")
    public MemberDto getMember(@PathVariable("id") String id){
        if(id.equals("ex")){
            throw new RuntimeException("잘못된 사용자"); //뷰페이지 반환 없음->500에러로 변환필요
        }
        if(id.equals("bad")){
            throw new IllegalArgumentException("잘못된 입력 값"); //WAS는 서버 내부 오류발생으로 500에러를 발생시킴
            // 이걸 400에러로 HandlerExceptionResolver로 변환시켜줘야함
        }

        return new MemberDto(id, "hello"+id);
    }


    @Data
    @AllArgsConstructor
    public class MemberDto{
        String memberId;
        String name;
    }
}
