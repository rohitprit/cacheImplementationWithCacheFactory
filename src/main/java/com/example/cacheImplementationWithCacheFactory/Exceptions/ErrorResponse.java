package com.example.cacheImplementationWithCacheFactory.Exceptions;

import java.util.List;
import java.util.Map;

public class ErrorResponse {
    private String error;
    private String status;
    private Map<String,Object> data;

    public ErrorResponse(String error, String status) {
        this.error = error;
        this.status = status;
    }
}
