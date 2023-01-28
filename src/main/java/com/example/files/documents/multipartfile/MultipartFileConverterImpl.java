package com.example.files.documents.multipartfile;
import com.example.files.documents.hash.service.ShaCalculatorService;
import com.example.files.documents.model.DocumentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used to generate a DocumentModel from a MultipartFile
 */
@Component
public class MultipartFileConverterImpl implements MultipartFileConverter {

    private ShaCalculatorService shaCalculatorService;

    @Autowired
    public MultipartFileConverterImpl(ShaCalculatorService shaCalculatorService) {
        this.shaCalculatorService = shaCalculatorService;
    }

    public List<DocumentModel> generateDocuments(MultipartFileContainer container) {
        List<DocumentModel> documentModels = new ArrayList<>();
        shaCalculatorService.validateHashType(container.getHashType());

        for (MultipartFile multipartFile : container.getMultipartFileList()) {
            DocumentModel model = generateDocument(multipartFile);
            this.applyShaFunctions(model, multipartFile, container.getHashType());
            documentModels.add(model);
        }

        return documentModels;
    }

    public DocumentModel generateDocument(MultipartFile multipartFile) {
        DocumentModel model = new DocumentModel();
        model.setFileName(multipartFile.getOriginalFilename());
        return model;
    }

    /**
     * Calculates all the SHA values for a document.
     * Set the 'hash' attribute of a document if is equal to the hashType given by a user
     * @param documentModel
     * @param multipartFile
     * @param hashType
     */
    public void applyShaFunctions(DocumentModel documentModel, MultipartFile multipartFile, String hashType) {
        this.shaCalculatorService.getShaMap().forEach((k, d) -> {
            String documentHash = d.hash(multipartFile);
            d.setHashValue(documentModel, documentHash);

            if (hashType.equals(k)) {
                documentModel.setHash(documentHash);
            }
        });
    }

}
