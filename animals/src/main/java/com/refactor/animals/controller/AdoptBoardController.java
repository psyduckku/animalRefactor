package com.refactor.animals.controller;

import com.refactor.animals.beans.entity.AnimalBoardVO;
import com.refactor.animals.service.AnimalBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/adoptBoard")
public class AdoptBoardController {

    private final AnimalBoardService animalBoardService;

    @RequestMapping("/adoptBoardList")
    public String adoptBoardList(AnimalBoardVO vo){
        List<AnimalBoardVO> list = animalBoardService.getAnimalList(vo);
        log.info("list={}",list);
        return "adoptBoardList";
    }


}
