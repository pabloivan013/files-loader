package com.example.files.documents.persistence;
import com.example.files.documents.model.DocumentModel;
public interface DocumentPersistence {

    DocumentModel save(DocumentModel documentModel);

    DocumentModel save(DocumentModel documentModel, String hashType);

}
