package com.example.files.documents.hash.functions;
import com.example.files.documents.hash.HashName;

public abstract class Sha256 implements HashName {
    public static final String SHA_256 = "SHA-256";

    @Override
    public String getHashName() {
        return SHA_256;
    }

}
