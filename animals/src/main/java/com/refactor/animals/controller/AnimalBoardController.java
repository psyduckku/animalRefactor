package com.refactor.animals.controller;

import com.refactor.animals.beans.dto.PagingResponse;
import com.refactor.animals.beans.dto.SearchDto;
import com.refactor.animals.beans.entity.AnimalBoardVO;
import com.refactor.animals.service.AnimalBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/animalBoard")
public class AnimalBoardController {

    private final AnimalBoardService animalBoardService;

    // 검색 조건 목록 설정
    @ModelAttribute("sortRegion")
    public Map<String, String> sortRegion(){
        Map<String, String> sortRegion = new LinkedHashMap<String, String>();
        sortRegion.put("지역선택", "지역선택");
        sortRegion.put("가평군", "41820");	sortRegion.put("경기도", "41000");
        sortRegion.put("고양시", "41280");	sortRegion.put("과천시", "41290");
        sortRegion.put("광명시", "41210");	sortRegion.put("광주시", "41610");
        sortRegion.put("구리시", "41310");	sortRegion.put("군포시", "41410");
        sortRegion.put("김포시", "41570");	sortRegion.put("남양주시", "41360");
        sortRegion.put("동두천시", "41250");	sortRegion.put("성남시", "41130");
        sortRegion.put("수원시", "41110");	sortRegion.put("시흥시", "41390");
        sortRegion.put("안산시", "41270");	sortRegion.put("안성시", "41550");
        sortRegion.put("안양시", "41170");	sortRegion.put("양주시", "41630");
        sortRegion.put("양평군", "41830");	sortRegion.put("여주시", "41670");
        sortRegion.put("연천군", "41800");   sortRegion.put("오산시", "41370");
        sortRegion.put("용인시", "41460");	sortRegion.put("의왕시", "41430");
        sortRegion.put("의정부시", "41150");	sortRegion.put("이천시", "41500");
        sortRegion.put("파주시", "41480");	sortRegion.put("평택시", "41220");
        sortRegion.put("포천시", "41650");	sortRegion.put("하남시", "41450");
        sortRegion.put("화성시", "41590");
        return sortRegion;
    }
    @ModelAttribute("sortSpecies")
    public Map<String, String> sortSpecies(){
        Map<String, String> sortSpecies = new LinkedHashMap<String, String>();
        sortSpecies.put("동물선택", "동물선택");
        sortSpecies.put("개", "개");
        sortSpecies.put("고양이", "고양이");
        sortSpecies.put("기타축종", "기타축종");
        return sortSpecies;
    }
    @RequestMapping("/animalBoardList") //@RequestParam은 자동으로 형변환을 해줌. ModelAttribute는 model에 따로 담을 필요 없이 뷰까지 전달함
    public String adoptBoardList(@ModelAttribute("params") SearchDto searchDto, Model model){
        // mybatis null 인식문제로 value부여하여 처리!

        log.info("searchDto={}",searchDto);
        if(searchDto==null||searchDto.getSortRegion()==null) {
            searchDto.setSortRegion("지역선택");
        }
        if(searchDto==null||searchDto.getSortSpecies()==null) {
            searchDto.setSortSpecies("동물선택");
        }
        PagingResponse<AnimalBoardVO> pagingResponse = animalBoardService.getAnimalList(searchDto);
        log.info("pagingResponse={}",pagingResponse);
        model.addAttribute("response", pagingResponse);

        return "/animalBoard/animalBoardList";
    }

    @GetMapping("/animalBoard")
    public String animalBoard(AnimalBoardVO vo, Model model){
        AnimalBoardVO info = animalBoardService.getAnimal(vo);
        model.addAttribute("info", info);
        return "/animalBoard/animalBoard";
    }
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/getAsideBoard")
    public List<AnimalBoardVO> getAsideList(AnimalBoardVO vo, Model model){
        List<AnimalBoardVO> asideList = animalBoardService.getAsideList(vo);
        return asideList;
    }
}
