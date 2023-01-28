package com.example.files.documents.hash.finder;
import com.example.files.documents.hash.functions.Sha512;
import com.example.files.documents.model.DocumentModel;
import com.example.files.documents.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Sha512DocumentFinder extends Sha512 implements DocumentHashFinder {

    private DocumentRepository documentRepository;

    @Autowired
    public Sha512DocumentFinder(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Optional<DocumentModel> find(String hashValue) {
        Optional<DocumentModel> documentModel = this.documentRepository.findBySha512(hashValue);
        documentModel.ifPresent(p -> p.setHash(hashValue));
        return documentModel;
    }
}
