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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/adoptBoard")
public class AdoptBoardController {

    private final AdoptBoardService service;

    @GetMapping("/adoptBoardList") //리스트보기
    public String adoptBoardList(@ModelAttribute("params") SearchDto searchDto, Model model) {

        log.info(searchDto.getSearchType());
        log.info(searchDto.getKeyword());
        if (searchDto == null) {
            searchDto.setSearchType("내용");
        }
        PagingResponse<AdoptBoardVO> pagingResponse = service.boardList(searchDto);
        log.info("controller pagingResponse={}", pagingResponse);

        model.addAttribute("response", pagingResponse);
        return "adoptBoardList";
    }

    @GetMapping("/{adt_id}") //보기
    public String adoptBoard(AdoptBoardVO vo, Model model) {
        AdoptBoardVO info = service.getBoard(vo);
        model.addAttribute("info", info);
        return "adoptBoard";
    }

    @GetMapping("/add") //게시물 쓰기
    public String add() {
        return "adoptBoardForm";
    }
    @PostMapping("/add") //게시물 저장
    public String save(@ModelAttribute AdoptBoardVO adoptBoardVO) {
        log.info("adoptBoardVO={}",adoptBoardVO);
        AdoptBoardVO result = service.inserBoard(adoptBoardVO);
        log.info("result={}",result);
        return "adoptBoard";
    }
}