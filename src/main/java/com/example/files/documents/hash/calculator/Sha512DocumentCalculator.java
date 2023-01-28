package com.example.files.documents.hash.calculator;

import com.example.files.documents.hash.functions.Sha512;
import com.example.files.documents.model.DocumentModel;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Sha512DocumentCalculator extends Sha512 implements DocumentHashCalculator {

    @Override
    public String hash(MultipartFile multipartFile) {
        try {
            return DigestUtils.sha512Hex(multipartFile.getInputStream());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setHashValue(DocumentModel documentModel, String hashValue) {
        documentModel.setHashSha512(hashValue);
    }

}
