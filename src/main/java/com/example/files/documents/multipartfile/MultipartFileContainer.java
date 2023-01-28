package com.example.files.documents.multipartfile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
public class MultipartFileContainer {

    private List<MultipartFile> multipartFileList;

    private String hashType;

    public MultipartFileContainer(List<MultipartFile> multipartFileList, String hashType) {
        this.multipartFileList = multipartFileList;
        this.hashType = hashType;
    }

    public List<MultipartFile> getMultipartFileList() {
        return multipartFileList;
    }

    public void setMultipartFileList(List<MultipartFile> multipartFileList) {
        this.multipartFileList = multipartFileList;
    }

    public String getHashType() {
        return hashType;
    }

    public void setHashType(String hashType) {
        this.hashType = hashType;
    }

}
