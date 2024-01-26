package com.refactor.animals.controller;

import com.refactor.animals.common.EmailUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RequestMapping("/email")
@Controller
@RequiredArgsConstructor
public class EmailController {

    private final EmailUtil emailUtil;
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @PostMapping("auth/sendEmail")
    public String sendEmail(@RequestBody Map<String, Object> params){
        log.info("email params={}", params);
        String email = (String) params.get("email");
        String code = (String) params.get("random_number");
        emailUtil.sendEmail(email, (String) params.get("subject"), (String) params.get("body"));
        return code;
    }
}
