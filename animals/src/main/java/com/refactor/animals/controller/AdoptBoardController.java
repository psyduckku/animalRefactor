package com.refactor.animals.controller;

import com.refactor.animals.beans.converter.AdoptBoardFormConverter;
import com.refactor.animals.beans.dto.AdoptBoardForm;
import com.refactor.animals.beans.dto.PagingResponse;
import com.refactor.animals.beans.dto.SearchDto;
import com.refactor.animals.beans.entity.AdoptBoardVO;
import com.refactor.animals.service.AdoptBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.refactor.animals.common.KeyCollection.LOGIN_ID;

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
        log.info("info={}", info);
        model.addAttribute("info", info);
        return "adoptBoard";
    }

    @GetMapping("/add") //게시물 쓰기폼
    public String add(@ModelAttribute AdoptBoardForm form) {

        return "adoptBoardForm";
    }
    @PostMapping("/add") //게시물 저장
    public String save(@ModelAttribute AdoptBoardForm adoptBoardForm, @SessionAttribute(name="login_id") String login_id,
                       RedirectAttributes rd) {

        adoptBoardForm.setLogin_id(login_id);
        log.info(adoptBoardForm.toString());

        AdoptBoardFormConverter converter = new AdoptBoardFormConverter();
        AdoptBoardVO vo = converter.converter(adoptBoardForm);
        int adt_id = service.insertBoard(vo);
        rd.addAttribute("adt_id",adt_id);
        log.info("add 컨트롤러 반환된 result.getAdt_id()={}", adt_id);
        return "redirect:/adoptBoard/{adt_id}";
    }
}