package com.refactor.animals.controller;


import com.refactor.animals.beans.entity.AnimalReplyBoardVO;
import com.refactor.animals.service.AnimalReplyBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/animalReplyBoard")
public class AnimalReplyBoardController {
    //service
    //repository-mapper
    private final AnimalReplyBoardService service;

    @ResponseBody
    @PostMapping("/boardList")
    public ResponseEntity<List<AnimalReplyBoardVO>> boardList(@ModelAttribute AnimalReplyBoardVO vo,@RequestBody String ASEQ){

        vo.setAseq(ASEQ);

        List<AnimalReplyBoardVO> list = service.boardList(vo);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
