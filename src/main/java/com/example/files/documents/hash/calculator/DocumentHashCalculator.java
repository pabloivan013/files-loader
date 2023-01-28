package com.example.files.documents.hash.calculator;
import com.example.files.documents.hash.HashName;
import com.example.files.documents.model.DocumentModel;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentHashCalculator extends HashName {
    String hash(MultipartFile multipartFile);

    /**
     * Set the Hash value based on the HashType
     * @param documentModel
     * @param hashValue
     */
    void setHashValue(DocumentModel documentModel, String hashValue);

}
