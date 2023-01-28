package com.example.files.documents.hash.service;
import com.example.files.documents.hash.calculator.DocumentHashCalculator;
import com.example.files.documents.hash.functions.Sha256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShaCalculatorService extends AShaMapperService<DocumentHashCalculator> {

    @Autowired
    public ShaCalculatorService(List<DocumentHashCalculator> documentHashCalculatorList) {
        super(documentHashCalculatorList);
    }

}
