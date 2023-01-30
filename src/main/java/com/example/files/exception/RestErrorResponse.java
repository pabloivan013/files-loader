package com.example.files.exception;
public class RestErrorResponse {

    private RestResponse error;

    public RestResponse getError() {
        return error;
    }

    public void setError(RestResponse error) {
        this.error = error;
    }
}
