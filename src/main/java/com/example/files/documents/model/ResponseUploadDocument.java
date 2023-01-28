package com.example.files.documents.model;
import com.example.files.documents.View.Views;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;
public class ResponseUploadDocument {

    @JsonView(Views.Public.class)
    private String algorithm;

    @JsonView(Views.Public.class)
    private List<DocumentModel> documents;

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public List<DocumentModel> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentModel> documents) {
        this.documents = documents;
    }
}
