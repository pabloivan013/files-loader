package com.example.files.documents.hash;
import com.example.files.documents.hash.functions.Sha256;
import com.example.files.documents.hash.functions.Sha512;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;
public class HashNotSupportedException extends ResponseStatusException {

    public static String DEFAULT_ERROR;
    public static HttpStatusCode DEFAULT_CODE;

    static {
        DEFAULT_ERROR = "The 'hash' parameter only could be " +
                "'"+Sha256.SHA_256 +"' or '"+ Sha512.SHA_512 +"'";
        DEFAULT_CODE = HttpStatus.BAD_REQUEST;
    }

    public HashNotSupportedException() {
        super(DEFAULT_CODE, DEFAULT_ERROR);
    }

}
