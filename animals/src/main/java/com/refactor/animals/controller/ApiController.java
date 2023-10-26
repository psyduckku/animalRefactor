package com.refactor.animals.controller;

import com.refactor.animals.beans.dto.JoinForm;
import com.refactor.animals.beans.dto.LoginForm;
import com.refactor.animals.beans.entity.AnimalBoardVO;
import com.refactor.animals.common.exception.UserException;
import com.refactor.animals.service.AnimalBoardService;
import com.refactor.animals.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@Slf4j
@RequestMapping("/animal/api")
@RequiredArgsConstructor
@RestController //@ResponseBody + @Controller // 메서드에 ResponseBody안써도됨
public class ApiController {
    private final UserService userService;
    private final AnimalBoardService animalBoardService;
    @PostMapping("/login")            //RequestBody => mediaType이 application/json임(json요청만받는다)
    public ResponseEntity<LoginForm> login(@RequestBody LoginForm loginForm, HttpServletRequest request) {

        LoginForm loginMember = userService.login(loginForm);
        //Service 로직에서 예외처리를 했기 때문에 Valid 불필요
        HttpSession session = request.getSession();
        String sessionId = UUID.randomUUID().toString(); // 따로 빼서 사용? . 얘 어케하지
        session.setAttribute("sessionId", sessionId); //세션 만료시간 추가하기

        return new ResponseEntity(loginMember, HttpStatus.OK);
    }

    @PostMapping("/join")
    public ResponseEntity<UserException> join(@Valid @RequestBody JoinForm joinForm) {
        log.info("joinForm={}", joinForm.toString());

        userService.join(joinForm);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/updateAnimals")
    public String updateAnimals(@RequestParam Map<String, Object> param, AnimalBoardVO vo) throws JSONException {
        //해당 데이터를 다루기 위해 Map-> 문자열 -> JSON 객체 변환
        log.info("target.getClass={}",param.getClass());
        JSONArray array = new JSONArray(param.get("target").toString());

        if(array.length()>0) {
            for(int i=0; i<array.length();i++) {
                vo.setSIGUN_CD((String) array.getJSONObject(i).get("SIGUN_CD"));
                vo.setSIGUN_NM((String) array.getJSONObject(i).get("SIGUN_NM"));
                vo.setABDM_IDNTFY_NO((String) array.getJSONObject(i).get("ABDM_IDNTFY_NO"));
                vo.setRECEPT_DE((String)array.getJSONObject(i).get("RECEPT_DE"));
                vo.setDISCVRY_PLC_INFO((String)array.getJSONObject(i).get("DISCVRY_PLC_INFO"));
                vo.setSTATE_NM((String)array.getJSONObject(i).get("STATE_NM"));
                vo.setPBLANC_IDNTFY_NO((String)array.getJSONObject(i).get("PBLANC_IDNTFY_NO"));
                vo.setPBLANC_BEGIN_DE((String)array.getJSONObject(i).get("PBLANC_BEGIN_DE"));
                vo.setPBLANC_END_DE((String)array.getJSONObject(i).get("PBLANC_END_DE"));
                vo.setSPECIES_NM((String)array.getJSONObject(i).get("SPECIES_NM"));
                vo.setCOLOR_NM((String) array.getJSONObject(i).get("COLOR_NM"));
                vo.setAGE_INFO((String)array.getJSONObject(i).get("AGE_INFO"));
                vo.setBDWGH_INFO((String)array.getJSONObject(i).get("BDWGH_INFO"));
                vo.setSEX_NM((String) array.getJSONObject(i).get("SEX_NM"));
                vo.setNEUT_YN((String) array.getJSONObject(i).get("NEUT_YN"));
                vo.setSFETR_INFO((String) array.getJSONObject(i).get("SFETR_INFO"));
                vo.setSHTER_NM((String) array.getJSONObject(i).get("SHTER_NM"));
                vo.setSHTER_TELNO((String) array.getJSONObject(i).get("SHTER_TELNO"));
                vo.setPROTECT_PLC((String) array.getJSONObject(i).get("PROTECT_PLC"));
                vo.setREFINE_ROADNM_ADDR((String) array.getJSONObject(i).get("REFINE_ROADNM_ADDR"));
                vo.setREFINE_LOTNO_ADDR((String) array.getJSONObject(i).get("REFINE_LOTNO_ADDR"));
                vo.setREFINE_ZIP_CD((String)array.getJSONObject(i).get("REFINE_ZIP_CD"));
                vo.setJURISD_INST_NM((String) array.getJSONObject(i).get("JURISD_INST_NM"));
                vo.setIMAGE_COURS((String) array.getJSONObject(i).get("IMAGE_COURS"));
                System.out.println(vo.toString());
                System.out.println(i);
                animalBoardService.insertAnimal(vo);
                System.out.println(vo.toString());
            }
            System.out.println("명단 setter완료");
        }

        return "ok";
    }


}
