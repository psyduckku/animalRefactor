package com.refactor.animals.controller;

import com.refactor.animals.beans.dto.ReplyForm;
import com.refactor.animals.beans.entity.AdoptReplyBoardVO;
import com.refactor.animals.service.AdoptReplyBoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/adoptReplyBoard")
@Controller
public class AdoptReplyBoardController {

    private final AdoptReplyBoardService adoptReplyBoardService;

    @ResponseBody
    @PostMapping("/insertReply")
    public ResponseEntity insertReply(@RequestBody ReplyForm form, HttpServletRequest request){
        log.info("adt_id:form.getAdt_id()={}",form.getAdt_id());
        HttpSession session = request.getSession(false);
        String login_id = (String) session.getAttribute("login_id");
        AdoptReplyBoardVO vo = new AdoptReplyBoardVO(form.getAdt_id(),form.getUpper_id(), login_id, form.getContent());
        log.info("vo={}", vo);
        int row = adoptReplyBoardService.insertReply(vo);
        log.info("row={}", row);
        return new ResponseEntity(row, HttpStatus.OK);
    }


}
