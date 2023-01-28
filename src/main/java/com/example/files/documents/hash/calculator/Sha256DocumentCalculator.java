package com.example.files.documents.hash.calculator;

import com.example.files.documents.hash.functions.Sha256;
import com.example.files.documents.model.DocumentModel;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Sha256DocumentCalculator extends Sha256 implements DocumentHashCalculator {

    @Override
    public String hash(MultipartFile multipartFile) {
        try {
            return DigestUtils.sha256Hex(multipartFile.getInputStream());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setHashValue(DocumentModel documentModel, String hashValue) {
        documentModel.setHashSha256(hashValue);
    }

}
