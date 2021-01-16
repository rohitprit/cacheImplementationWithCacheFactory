package com.example.cacheImplementationWithCacheFactory.service;

import com.example.cacheImplementationWithCacheFactory.model.OkResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CacheService {
    public OkResponse createCache(String cachePolicy, int cacheSize);
    public OkResponse insert(String cachePolicy, int key, int value);
    public OkResponse get(String cachePolicy, int key);
    public OkResponse getData(String cachePolicy);
}
