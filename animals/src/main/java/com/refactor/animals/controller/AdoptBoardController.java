package com.refactor.animals.controller;

import com.refactor.animals.beans.dto.AdoptBoardForm;
import com.refactor.animals.beans.dto.PagingResponse;
import com.refactor.animals.beans.dto.SearchDto;
import com.refactor.animals.beans.entity.*;
import com.refactor.animals.service.AdoptBoardService;
import com.refactor.animals.service.UploadFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/adoptBoard")
public class AdoptBoardController {

    private final AdoptBoardService adoptBoardservice;
    private final FileStore fileStore;
    private final UploadFileService uploadFileService;

    @GetMapping("/adoptBoardList") //리스트보기
    public String adoptBoardList(@ModelAttribute("params") SearchDto searchDto, Model model) {

        log.info(searchDto.getSearchType());
        log.info(searchDto.getKeyword());
        if (searchDto == null) {
            searchDto.setSearchType("내용");
        }
        PagingResponse<AdoptBoardVO> pagingResponse = adoptBoardservice.boardList(searchDto);
        log.info("controller pagingResponse={}", pagingResponse);

        model.addAttribute("response", pagingResponse);
        return "adoptBoardList";
    }

    @GetMapping("/{adt_id}") //보기
    public String adoptBoard(AdoptBoardVO vo, Model model) { //vo 필드에 adt_id가 일치할 경우 자동으로 바인딩됨
        AdoptBoardVO board = adoptBoardservice.getBoard(vo);
        List<UploadFileVO> files = uploadFileService.getFiles(vo.getAdt_id());
        log.info("files={}",files);
        model.addAttribute("board", board);
        model.addAttribute("files", files);
        return "adoptBoard";
    }

    @GetMapping("/add") //게시물 쓰기폼
    public String add(@ModelAttribute AdoptBoardForm form, Model model) {
        model.addAttribute("adoptBoardForm", form);
        return "adoptBoardForm";
    }
//    @PostMapping("/add") //게시물 저장
    public String saveBoard(@ModelAttribute AdoptBoardForm adoptBoardForm, @SessionAttribute(name="login_id") String login_id,
                       RedirectAttributes redirectAttributes) throws IOException {

//        adoptBoardForm.setLogin_id(login_id);
//        AdoptBoardVO adoptBoardVO = new AdoptBoardVO(adoptBoardForm.getLogin_id(),
//                adoptBoardForm.getTitle(), adoptBoardForm.getContent());
//
//        int adt_id = adoptBoardservice.insertBoard(adoptBoardVO);
//        log.info("adt_id={}",adt_id);
//        log.info(adoptBoardForm.getImage_files().toString());

//            List<UploadFileVO> storeFileList = fileStore.storeFiles(adoptBoardForm.getImage_files(), adt_id); //파일업로드
//            log.info("저장된 파일정보 storeFileList={}",storeFileList);
//            if(!storeFileList.isEmpty()){
//                int row = uploadFileService.insertFiles(storeFileList);
//                log.info("업로드된 파일 row={}", row);
                //이제 mapper에서 원본, 저장된파일, 확장자. 이렇게 3개 저장하기
//            }

//        redirectAttributes.addAttribute("adt_id",adt_id);
        return "redirect:/adoptBoard/{adt_id}";
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value ="/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public int saveBoard2(@RequestPart(value="adoptBoardForm") AdoptBoardForm adoptBoardForm, @RequestPart(value="file") List<MultipartFile> file) throws IOException {
        log.info("폼데이터adoptBoardForm={}", adoptBoardForm);

        file.stream().map(MultipartFile::getOriginalFilename).forEach(fileName -> {
            log.info("파일이름: {}", fileName);
        });

        AdoptBoardVO vo = new AdoptBoardVO(adoptBoardForm.getLogin_id(), adoptBoardForm.getTitle(), adoptBoardForm.getContent());
        int adt_id = adoptBoardservice.insertBoard(vo);
        List<UploadFileVO> storeFileList = fileStore.storeFiles(file, adt_id);
        if(!storeFileList.isEmpty()){
            int row = uploadFileService.insertFiles(storeFileList);
            log.info("upload된 row={}",row);
        }

        return adt_id;
    }

    @ResponseBody
    @GetMapping("/images/{filename}") //이미지 보이게
    public Resource drawImage(@PathVariable String filename) throws MalformedURLException {
        return new UrlResource("file:"+fileStore.getFullPath(filename));
    }
    @GetMapping("/attach/{store_id}") //헤더 설정을 위해 반환타입을 ResponseEntity로
    public ResponseEntity<Resource> downloadImage(@PathVariable int store_id) throws MalformedURLException {
        UploadFileVO file = uploadFileService.downloadImage(store_id);
        String store_file_name = file.getStore_file_name();
        String upload_file_name = file.getUpload_file_name();
        UrlResource resource = new UrlResource("file:" + fileStore.getFullPath(store_file_name));
        String encodedUploadFileName = UriUtils.encode(upload_file_name, StandardCharsets.UTF_8);
        String contentDisposition = "attachment; filename=\"" + encodedUploadFileName + "\"";

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .body(resource);
    }

    @PostMapping("/bookmark/{adt_id}")
    public ResponseEntity markUp(@PathVariable int adt_id, @RequestBody boolean bookmark, AdoptBoardVO vo){
        log.info("adt_id={}",adt_id);
        log.info("북마크 bookmark={}",bookmark);
        int count = adoptBoardservice.bookmarkCount();
        log.info("카운트count={}",count);
        log.info("북마크bookmark={}", bookmark);
        vo.setAdt_id(adt_id);

        if(bookmark==true && count >4){
            return new ResponseEntity("\"over\"",HttpStatus.OK);
        }else if(bookmark==true){
            vo.setBookmark(true);
            adoptBoardservice.bookmark(vo);
            return new ResponseEntity(true, HttpStatus.OK);
        }

            vo.setBookmark(false);
            adoptBoardservice.bookmark(vo);
        return new ResponseEntity(false, HttpStatus.OK);
    }
//    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @PostMapping("/bookmarkList")
    public Map<String, List<?>> bookmarkList(){
        Map<String, List<?>> map = new HashMap<>();
        List<AdoptBoardBookMarkVO> list = adoptBoardservice.bookmarkList();
        List<ThumbnailVO> thumbnailList = new ArrayList<>();
        for (AdoptBoardBookMarkVO li : list) {
            ThumbnailVO fileName = uploadFileService.getThumbnail(li.getAdt_id());
            thumbnailList.add(fileName);
        }
        map.put("boardList",list);
        map.put("thumbnailList", thumbnailList);

        return map;
    }

    @RequestMapping("/deleteBoard/{adt_id}")
    public String deleteBoard(@PathVariable int adt_id){
        int deleteFile = uploadFileService.deleteFile(adt_id);
        log.info("삭제된 파일 deleteFile={}",deleteFile);
        int result = adoptBoardservice.deleteBoard(adt_id);
        log.info("삭제된 게시글 result={}", result);

        return "redirect:/adoptBoard/adoptBoardList";
    }

    @RequestMapping("/updateBoardForm/{adt_id}")
    public String updateBoardForm(@PathVariable int adt_id, AdoptBoardVO vo, Model model){
        vo.setAdt_id(adt_id);
        AdoptBoardVO board = adoptBoardservice.getBoard(vo);
        model.addAttribute("board", board);


        return "adoptBoardUpdateForm";
    }

    @ResponseBody
    @PostMapping(value="/updateBoard/{adt_id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity updateBoard(@PathVariable int adt_id, @RequestPart(value="adoptBoardForm") AdoptBoardForm form,
                                        @RequestPart(value="file") MultipartFile file){

        form.setAdt_id(adt_id);
        AdoptBoardVO vo =  new AdoptBoardVO(form.getAdt_id(), form.getTitle(), form.getContent());
        int row =  adoptBoardservice.updateBoard(vo);
        log.info("adt_id={}",adt_id);
        log.info("row={}",row);

        return new ResponseEntity(row, HttpStatus.OK);
    }

}