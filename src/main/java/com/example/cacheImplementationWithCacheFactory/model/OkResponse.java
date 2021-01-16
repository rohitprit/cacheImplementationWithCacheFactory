package com.example.cacheImplementationWithCacheFactory.model;

import lombok.Data;

import java.util.Map;

@Data
public class OkResponse {
    private String message;
    private String status;
    private Map<String,Object> data;
    public OkResponse(String status) {
        this.status = status;
    }
}
