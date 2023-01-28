package com.example.files.documents.hash.service;

import com.example.files.documents.hash.HashNotSupportedException;
import com.example.files.documents.hash.HashName;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AShaMapperService<T extends HashName> {

    private final Map<String, T> shaMap;

    protected AShaMapperService(Map<String, T> shaMap) {
        this.shaMap = shaMap;
    }

    protected AShaMapperService(List<T> shaList) {
        this.shaMap = loadShaMap(shaList);
    }

    public Map<String, T> loadShaMap(List<T> shaList) {
       return shaList.stream()
               .collect(Collectors.toMap(HashName::getHashName, Function.identity()));
    }

    public T getShaServiceValue(String hashType) {
        validateHashType(hashType);
        return shaMap.get(hashType);
    }

    public void validateHashType(String hashType) {
        if (!shaMap.containsKey(hashType)) {
            throw new HashNotSupportedException();
        }
    }

    public Map<String, T> getShaMap() {
        return shaMap;
    }

}
