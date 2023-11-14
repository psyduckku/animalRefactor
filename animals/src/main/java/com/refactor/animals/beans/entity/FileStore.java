package com.refactor.animals.beans.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileStore {

    @Value("${file.dir}") //application.properties에 지정한 경로 값을 가져옴
    private String file_dir;

    public String getFullPath(String filename){
        return file_dir+filename;
    }

    public List<UploadFileVO> storeFiles(List<MultipartFile> multipartFiles, int adt_id) throws IOException {
        List<UploadFileVO> storeFileResult = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            if(!multipartFile.isEmpty()){

                storeFileResult.add(storeFile(multipartFile, adt_id, multipartFile.getSize()));
            }
        }
        return storeFileResult;
    }
    public UploadFileVO storeFile(MultipartFile multipartFile, int adt_id, long file_size) throws IOException {
        if(multipartFile.isEmpty()){
            return null;
        }
        String upload_file_name = multipartFile.getOriginalFilename();
        String storeFilename = createStoreFilename(upload_file_name);
        multipartFile.transferTo(new File(getFullPath(storeFilename)));
        String ext_name = extracted(storeFilename);
        double kByte = file_size / (1024);

        return new UploadFileVO(adt_id, upload_file_name, storeFilename, ext_name, kByte);
    }

    private static String createStoreFilename(String originalFilename) {
        String ext = extracted(originalFilename);
        String uuid = UUID.randomUUID().toString();
        return uuid+"."+ext;
    }

    private static String extracted(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }


}
