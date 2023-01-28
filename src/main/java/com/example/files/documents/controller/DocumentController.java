package com.example.files.documents.controller;

import com.example.files.documents.View.Views;
import com.example.files.documents.model.DocumentModel;
import com.example.files.documents.model.ResponseUploadDocument;
import com.example.files.documents.service.DocumentService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin(value = "*")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @JsonView(Views.globalHash.class)
    @PostMapping("/documents/hash")
    public ResponseEntity<ResponseUploadDocument> uploadDocuments(@RequestParam("documents")MultipartFile[] documents, @RequestParam(value = "hashType") String sha) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(documentService.processDocumentsPersistence(List.of(documents), sha));
        } catch (Exception e) {
            throw new ResponseStatusException(400, e.getMessage(), e);
        }
    }

    @JsonView(Views.customHash.class)
    @GetMapping(value = "/documents")
    public ResponseEntity<List<DocumentModel>> getDocuments() {
        return ResponseEntity.ok(this.documentService.findDocuments());
    }

    @JsonView(Views.globalHash.class)
    @GetMapping(value = "/documents", params = {"hash", "hashType"})
    public ResponseEntity<DocumentModel> getDocumentsByHash(@RequestParam("hash") String hash, @RequestParam("hashType") String hashType) {
        return ResponseEntity.ok(this.documentService.findDocumentByHash(hash, hashType));
    }

}
