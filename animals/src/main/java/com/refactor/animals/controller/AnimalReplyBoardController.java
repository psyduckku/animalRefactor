package com.refactor.animals.controller;


import com.refactor.animals.beans.dto.ReplyParam;
import com.refactor.animals.beans.entity.AnimalReplyBoardVO;
import com.refactor.animals.service.AnimalReplyBoardService;
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

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/animalReplyBoard")
public class AnimalReplyBoardController {
    //service
    //repository-mapper
    private final AnimalReplyBoardService animalReplyBoardService;

    @ResponseBody
    @PostMapping("/insertReply")
    public ResponseEntity insertReply(@RequestBody ReplyParam vo, HttpSession session){
        log.info("vo={}", vo);
        String login_id = (String) session.getAttribute("login_id");
        vo.setLogin_id(login_id);
        int row = animalReplyBoardService.insertReply(vo);
        return ResponseEntity.ok(row);
    }

    @ResponseBody
    @PostMapping("/getReplyList")
    public ResponseEntity<List<AnimalReplyBoardVO>> boardList(@RequestBody int aseq, AnimalReplyBoardVO vo){
        log.info("aseq={}",aseq);
        vo.setAseq(aseq);
//        vo.setAseq(Integer.valueOf(ASEQ));
        List<AnimalReplyBoardVO> list = animalReplyBoardService.getReplyList(vo);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }



}
