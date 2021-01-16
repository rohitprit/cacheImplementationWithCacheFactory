package com.example.cacheImplementationWithCacheFactory.service;

import com.example.cacheImplementationWithCacheFactory.cacheManager.CacheFactory;
import com.example.cacheImplementationWithCacheFactory.model.OkResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CacheServiceImpl implements CacheService{
    public OkResponse createCache(String cachePolicy, int cacheSize){
        CacheFactory.getInstance(cacheSize).initCache(cachePolicy);
        return new OkResponse("OK");
    }

    @Override
    public OkResponse insert(String cachePolicy, int key, int value) {
        CacheFactory.getInstance().getCache().putValue(key, value);
        return new OkResponse("OK");
    }

    @Override
    public OkResponse get(String cachePolicy, int key) {
        OkResponse okResponse = new OkResponse("OK");
        Map map=new HashMap<>();
        map.put("data", CacheFactory.getInstance().getCache().getValue(key));
        okResponse.setData(map);
        return okResponse;
    }

    @Override
    public OkResponse getData(String cachePolicy) {
        OkResponse okResponse = new OkResponse("OK");
        Map map=new HashMap<>();
        map.put("data", CacheFactory.getInstance().getCache().getData());
        okResponse.setData(map);
        return okResponse;
    }
}
