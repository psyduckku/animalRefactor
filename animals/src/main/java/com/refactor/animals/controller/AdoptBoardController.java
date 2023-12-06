package com.refactor.animals.controller;

import com.refactor.animals.beans.dto.AdoptBoardForm;
import com.refactor.animals.beans.dto.PagingResponse;
import com.refactor.animals.beans.dto.ReplyParam;
import com.refactor.animals.beans.dto.SearchDto;
import com.refactor.animals.beans.entity.*;
import com.refactor.animals.service.AdoptBoardService;
import com.refactor.animals.service.AdoptReplyBoardService;
import com.refactor.animals.service.UploadFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final AdoptReplyBoardService adoptReplyBoardService;
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

        model.addAttribute("response", pagingResponse);
        return "/adoptBoard/adoptBoardList";
    }

    @GetMapping("/{adt_id}")
    public String adoptBoard(AdoptBoardVO vo, Model model, ReplyParam param) { //vo 필드에 adt_id가 일치할 경우 자동으로 바인딩됨
        AdoptBoardVO board = adoptBoardservice.getBoard(vo);
        List<UploadFileVO> files = uploadFileService.getFiles(vo.getAdt_id());
        param.setAdt_id(param.getAdt_id());
        List<AdoptReplyBoardVO> replyList = adoptReplyBoardService.getReplyList(param);
        model.addAttribute("board", board);
        model.addAttribute("replyList", replyList);
        model.addAttribute("files", files);
        log.info("aa");
        return "/adoptBoard/adoptBoard";
    }

    @GetMapping("/add") //게시물 쓰기폼
    public String add(@ModelAttribute AdoptBoardForm form, Model model) {
        model.addAttribute("adoptBoardForm", form);
        return "/adoptBoard/adoptBoardForm";
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value ="/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public int saveBoard2(@RequestPart(value="adoptBoardForm") AdoptBoardForm adoptBoardForm, @RequestPart(value="file") List<MultipartFile> file) throws IOException {

        file.stream().map(MultipartFile::getOriginalFilename).forEach(fileName -> {
        });

        AdoptBoardVO vo = new AdoptBoardVO(adoptBoardForm.getLogin_id(), adoptBoardForm.getTitle(), adoptBoardForm.getContent());
        int adt_id = adoptBoardservice.insertBoard(vo);
        List<UploadFileVO> storeFileList = fileStore.storeFiles(file, adt_id);
        if(!storeFileList.isEmpty()){
            int row = uploadFileService.insertFiles(storeFileList);
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
        int count = adoptBoardservice.bookmarkCount();
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
        int result = adoptBoardservice.deleteBoard(adt_id);

        return "redirect:/adoptBoard/adoptBoardList";
    }

    @RequestMapping("/updateBoardForm/{adt_id}")
    public String updateBoardForm(@PathVariable int adt_id, AdoptBoardVO vo, Model model){
        vo.setAdt_id(adt_id);
        AdoptBoardVO board = adoptBoardservice.getBoard(vo);
        model.addAttribute("board", board);


        return "/adoptBoard/adoptBoardUpdateForm";
    }

    @ResponseBody
    @PostMapping(value="/updateBoard/{adt_id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity updateBoard(@PathVariable int adt_id, @RequestPart(value="adoptBoardForm") AdoptBoardForm form,
                                        @RequestPart(value="file") MultipartFile file){

        form.setAdt_id(adt_id);
        AdoptBoardVO vo =  new AdoptBoardVO(form.getAdt_id(), form.getTitle(), form.getContent());
        int row =  adoptBoardservice.updateBoard(vo);

        return new ResponseEntity(row, HttpStatus.OK);
    }

}