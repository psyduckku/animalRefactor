package com.refactor.animals.controller;

import com.refactor.animals.beans.dto.PagingResponse;
import com.refactor.animals.beans.dto.SearchDto;
import com.refactor.animals.beans.entity.AdoptBoardVO;
import com.refactor.animals.service.AdoptBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/adoptBoard")
public class AdoptBoardController {

    private final AdoptBoardService service;

    @GetMapping("/adoptBoardList")
    public String adoptBoardList(@ModelAttribute("params") SearchDto searchDto, Model model){

        if(searchDto==null){
            searchDto.setSearchType("내용");
        }
        PagingResponse<AdoptBoardVO> pagingResponse = service.boardList(searchDto);
        log.info("controller pagingResponse={}",pagingResponse);

        model.addAttribute("response", pagingResponse);
        return "adoptBoardList";
    }

    @GetMapping("/adoptBoard")
    public String adoptBoard(AdoptBoardVO vo){
        service.getBoard(vo);
        return "adoptBoard";
    }
}
