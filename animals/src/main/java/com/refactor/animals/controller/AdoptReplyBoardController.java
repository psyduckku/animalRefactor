package com.refactor.animals.controller;

import com.refactor.animals.beans.dto.ReplyForm;
import com.refactor.animals.beans.dto.ReplyParam;
import com.refactor.animals.beans.entity.AdoptReplyBoardVO;
import com.refactor.animals.service.AdoptReplyBoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @ResponseBody
    @PostMapping("/good")
    public ResponseEntity good(@RequestBody ReplyParam param){
        int row= 0;
        log.info("param={}", param);
        AdoptReplyBoardVO check = adoptReplyBoardService.checkEvaluation(param);
            log.info("/good 체크 check={}", check);
            log.info("/good 체크 카운트 check.getGood_count()={}", check.getGood_count());

            if(param.isGood()==true){
                param.setGood(false);
                param.setGood_count(check.getGood_count()-1);
            }else{
                param.setGood(true);
                param.setGood_count(check.getGood_count()+1);
            }
            row = adoptReplyBoardService.goodEvaluation(param);

            log.info("row={}", row);

            if(row<1){
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/bad")
    public ResponseEntity bad(@RequestBody ReplyParam param){
        int row;


        AdoptReplyBoardVO check = adoptReplyBoardService.checkEvaluation(param);
        log.info("/bad 체크 check={}", check);
        log.info("/베드카운트 check.getBad_count()={}", check.getBad_count());

        if(param.isBad()==true){
            param.setBad(false);
            param.setBad_count(check.getBad_count()-1);
        }else{
            param.setBad(true);
            param.setBad_count(check.getBad_count()+1);
        }
        row = adoptReplyBoardService.badEvaluation(param);
        if(row<1){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/deleteReply")
    public ResponseEntity deleteReply(@RequestBody ReplyParam param){

        int row = adoptReplyBoardService.deleteReply(param);
        if(row<1){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.OK);
    }




}
