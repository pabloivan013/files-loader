package com.example.files.documents.hash.functions;
import com.example.files.documents.hash.HashName;

public abstract class Sha512 implements HashName {
    public static final String SHA_512 = "SHA-512";

    @Override
    public String getHashName() {
        return SHA_512;
    }

}
