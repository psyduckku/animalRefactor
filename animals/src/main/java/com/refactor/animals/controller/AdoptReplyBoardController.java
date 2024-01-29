package com.refactor.animals.controller;

import com.refactor.animals.beans.dto.ReplyAddInfoParam;
import com.refactor.animals.beans.dto.ReplyParam;
import com.refactor.animals.beans.entity.AdoptReplyBoardVO;
import com.refactor.animals.beans.entity.ReplyAddInfo;
import com.refactor.animals.service.AdoptReplyBoardService;
import com.refactor.animals.service.ReplyAddInfoService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
    public ResponseEntity insertReply(@RequestBody ReplyParam param){

        log.info("param={}",param);
        int row = adoptReplyBoardService.insertReply(param);
        if(row<1){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("insert failed");
        }
        LocalDateTime currDate = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("YYYY-mm-dd HH:mm:ss");
        String regdate = currDate.format(format);
        param.setCreDate(regdate);

        return ResponseEntity.ok(param);
    }

    @ResponseBody
    @GetMapping("/{adt_id}")
    public ResponseEntity getReplyList(@PathVariable int adt_id, ReplyParam param){

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
    @PostMapping("/addGood")
    public ResponseEntity addGood(@RequestBody ReplyAddInfo replyAddInfo){
        log.info("reply_id={}",replyAddInfo.getReply_id());
        log.info(replyAddInfo.getLogin_id());
        log.info("replyAddInfo.getAdt_id()={}",replyAddInfo.getAdt_id());
        log.info("replyAddInfo.getGood_status()={}",replyAddInfo.getGood_status());
        int row = replyAddInfoService.addGood(replyAddInfo);
        int row2 = adoptReplyBoardService.addGoodCount(replyAddInfo.getReply_id());

        return ResponseEntity.ok(row);
    }

    @ResponseBody
    @PostMapping("/addBad")
    public ResponseEntity bad(@RequestBody ReplyAddInfo replyAddInfo){



        return ResponseEntity.ok("row");
    }

    @ResponseBody
    @GetMapping("minGood")
    public ResponseEntity minGood(){

        return ResponseEntity.ok("row");
    }

    @ResponseBody
    @PostMapping("/deleteReply")
    public ResponseEntity deleteReply(@RequestBody ReplyParam param){

        int row = adoptReplyBoardService.deleteReply(param);
        if(row<1){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok("ok");
    }




}
