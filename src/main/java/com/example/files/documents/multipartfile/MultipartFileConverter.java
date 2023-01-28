package com.example.files.documents.multipartfile;
import com.example.files.documents.model.DocumentModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
public interface MultipartFileConverter {

    List<DocumentModel> generateDocuments(MultipartFileContainer container);

    DocumentModel generateDocument(MultipartFile multipartFile);

}
