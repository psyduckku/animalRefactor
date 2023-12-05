package com.refactor.animals.controller;

import com.refactor.animals.beans.dto.ReplyAddInfoParam;
import com.refactor.animals.beans.dto.ReplyForm;
import com.refactor.animals.beans.dto.ReplyParam;
import com.refactor.animals.beans.entity.AdoptReplyBoardVO;
import com.refactor.animals.beans.entity.ReplyAddInfo;
import com.refactor.animals.service.AdoptReplyBoardService;
import com.refactor.animals.service.ReplyAddInfoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/adoptReplyBoard")
@Controller
public class AdoptReplyBoardController {

    private final AdoptReplyBoardService adoptReplyBoardService;
    private final ReplyAddInfoService replyAddInfoService;

    @ResponseBody
    @PostMapping("/insertReply")
    public ResponseEntity insertReply(@RequestBody ReplyForm form, HttpServletRequest request, ReplyAddInfo addInfoVO){
        log.info("adt_id:form.getAdt_id()={}",form.getAdt_id());
        HttpSession session = request.getSession(false);
        String login_id = (String) session.getAttribute("login_id");
        AdoptReplyBoardVO vo = new AdoptReplyBoardVO(form.getAdt_id(),form.getUpper_id(), login_id, form.getContent());
        log.info("vo={}", vo);
        int reply_id = adoptReplyBoardService.insertReply(vo);
        addInfoVO.setReply_id(reply_id);
        addInfoVO.setTable_name("adopt_board");
        int row = replyAddInfoService.insertReplyAddInfo(addInfoVO);
        if(row<1){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");
        }
        log.info("reply_id={}", reply_id);
        return ResponseEntity.ok(row);
    }

    @ResponseBody
    @GetMapping("/{adt_id}")
    public ResponseEntity getReplyList2(@PathVariable int adt_id, ReplyParam param){

        param.setAdt_id(adt_id);
        List<AdoptReplyBoardVO> list = adoptReplyBoardService.getReplyList(param);
        log.info("list={}", list);

        return ResponseEntity.ok(list);
    }

    @ResponseBody
    @PostMapping("/getListAddInfo")
    public ResponseEntity getListAddInfo(@RequestBody ReplyAddInfoParam param){
        log.info("adt_id={}",param.getAdt_id());
        log.info("reply_id_arr={}", param.getReply_id_arr());
        log.info("param.getLogin_id={}", param.getLogin_id());
        List<ReplyAddInfo> replyAddInfoList = new ArrayList<>();
        param.getReply_id_arr().forEach(reply_id ->{
            param.setReply_id(reply_id);
            ReplyAddInfo info = replyAddInfoService.getReplyAddInfo(param);
            replyAddInfoList.add(info);
        });
        log.info("replyAddInfoList={}",replyAddInfoList);
        if(replyAddInfoList.isEmpty()){
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok(replyAddInfoList);
    }

    @ResponseBody
    @PostMapping("/good")
    public ResponseEntity good(@RequestBody ReplyParam param){


        return new ResponseEntity(HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/bad")
    public ResponseEntity bad(@RequestBody ReplyParam param){



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
