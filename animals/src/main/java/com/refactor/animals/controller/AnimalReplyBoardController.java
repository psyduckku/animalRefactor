package com.refactor.animals.controller;


import com.refactor.animals.beans.dto.ReplyForm;
import com.refactor.animals.beans.entity.AdoptReplyBoardVO;
import com.refactor.animals.beans.entity.AnimalReplyBoardVO;
import com.refactor.animals.service.AnimalReplyBoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.Session;
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
    @PostMapping("{adt_id}")
    public ResponseEntity<List<AnimalReplyBoardVO>> boardList(int adt_id, @ModelAttribute AnimalReplyBoardVO vo){

        List<AnimalReplyBoardVO> list = animalReplyBoardService.boardList(vo);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }



}
