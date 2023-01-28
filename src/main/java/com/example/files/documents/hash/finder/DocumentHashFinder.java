package com.example.files.documents.hash.finder;
import com.example.files.documents.hash.HashName;
import com.example.files.documents.model.DocumentModel;

import java.util.Optional;
public interface DocumentHashFinder extends HashName {

    Optional<DocumentModel> find(String hashValue);

}
