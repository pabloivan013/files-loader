package com.example.files.documents.hash.service;
import com.example.files.documents.hash.finder.DocumentHashFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShaFinderService extends AShaMapperService<DocumentHashFinder> {

    @Autowired
    public ShaFinderService(List<DocumentHashFinder> documentHashFinder) {
        super(documentHashFinder);
    }
}
