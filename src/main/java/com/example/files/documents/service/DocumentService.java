package com.example.files.documents.service;
import com.example.files.documents.hash.service.ShaFinderService;
import com.example.files.documents.multipartfile.MultipartFileContainer;
import com.example.files.documents.model.DocumentModel;
import com.example.files.documents.model.ResponseUploadDocument;
import com.example.files.documents.multipartfile.MultipartFileConverter;
import com.example.files.documents.persistence.DocumentPersistence;
import com.example.files.documents.repository.DocumentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    private DocumentRepository documentRepository;
    private MultipartFileConverter multipartfileConverter;
    private DocumentPersistence documentPersistence;
    private ShaFinderService shaFinderService;

    @Autowired
    public DocumentService(DocumentRepository documentRepository, MultipartFileConverter multipartfileConverter, DocumentPersistence documentPersistence, ShaFinderService shaFinderService) {
        this.documentRepository = documentRepository;
        this.multipartfileConverter = multipartfileConverter;
        this.documentPersistence = documentPersistence;
        this.shaFinderService = shaFinderService;
    }

    @Transactional
    public List<DocumentModel> persistDocuments(List<DocumentModel> documentModels, String hashType) {
        return documentModels.stream().map(d -> {
            return this.documentPersistence.save(d, hashType);
        }).toList();
    }

    public ResponseUploadDocument processDocumentsPersistence(List<MultipartFile> multipartFileList, String hashType) {
        MultipartFileContainer multipartfileContainer = new MultipartFileContainer(multipartFileList, hashType);
        List<DocumentModel> documentModels = this.multipartfileConverter.generateDocuments(multipartfileContainer);

        // Save documents models
        documentModels = persistDocuments(documentModels, multipartfileContainer.getHashType());

        // Generate response
        ResponseUploadDocument responseUploadDocument = new ResponseUploadDocument();
        responseUploadDocument.setAlgorithm(multipartfileContainer.getHashType());
        responseUploadDocument.setDocuments(documentModels);

        return responseUploadDocument;
    }

    public List<DocumentModel> findDocuments() {
        return this.documentRepository.findAll();
    }

    public DocumentModel findDocumentByHash(String hash, String hashType) {
        Optional<DocumentModel> documentModelOptional = this.shaFinderService.getShaServiceValue(hashType).find(hash);

        if (documentModelOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Document with that value not found");
        }

        return documentModelOptional.get();
    }

}
