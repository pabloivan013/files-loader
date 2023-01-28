package com.example.files.documents.persistence;
import com.example.files.documents.hash.service.ShaFinderService;
import com.example.files.documents.model.DocumentModel;
import com.example.files.documents.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class DocumentHashPersistenceImpl implements DocumentPersistence {

    private DocumentRepository documentRepository;
    private ShaFinderService shaFinderService;

    @Autowired
    public DocumentHashPersistenceImpl(DocumentRepository documentRepository, ShaFinderService shaFinderService) {
        this.documentRepository = documentRepository;
        this.shaFinderService = shaFinderService;
    }

    @Override
    public DocumentModel save(DocumentModel documentModel) {
        return documentRepository.save(documentModel);
    }

    @Override
    public DocumentModel save(DocumentModel documentModel, String hashType) {
        // Check if document already exists in DB
        Optional<DocumentModel> documentModelOptional = shaFinderService.getShaServiceValue(hashType).find(documentModel.getHash());
        DocumentModel _auxDocument = documentModel;

        if (documentModelOptional.isPresent()) {
            _auxDocument = documentModelOptional.get();
            _auxDocument.setLastUpload(LocalDateTime.now(ZoneOffset.UTC));
        }

        this.save(_auxDocument);
        return _auxDocument;
    }

}
