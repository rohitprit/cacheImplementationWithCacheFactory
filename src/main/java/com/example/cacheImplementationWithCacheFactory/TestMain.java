package com.example.cacheImplementationWithCacheFactory;

import com.example.cacheImplementationWithCacheFactory.cacheManager.Cache;
import com.example.cacheImplementationWithCacheFactory.cacheManager.CacheEvictionPolicies;
import com.example.cacheImplementationWithCacheFactory.cacheManager.CacheFactory;

public class TestMain {

    public static void main(String[] args) {

        CacheFactory cacheFactory = CacheFactory.getInstance(5);

        Cache cacheLRU = cacheFactory.initCache(CacheEvictionPolicies.LRU.name()).getCache();
        cacheLRU.putValue(1, 'A');
        System.out.println(cacheLRU.getData());
        System.out.println(cacheLRU.getEvictionList());
        cacheLRU.putValue(2, 'B');
        System.out.println(cacheLRU.getData());
        System.out.println(cacheLRU.getEvictionList());
        cacheLRU.putValue(3, 'C');
        System.out.println(cacheLRU.getData());
        System.out.println(cacheLRU.getEvictionList());
        cacheLRU.putValue(4, 'D');
        System.out.println(cacheLRU.getData());
        System.out.println(cacheLRU.getEvictionList());
        cacheLRU.putValue(5, 'E');
        System.out.println(cacheLRU.getData());
        System.out.println(cacheLRU.getEvictionList());
        cacheLRU.putValue(6, 'F');
        System.out.println(cacheLRU.getData());
        System.out.println(cacheLRU.getEvictionList());
        cacheLRU.putValue(2, 'B');
        System.out.println(cacheLRU.getData());
        System.out.println(cacheLRU.getEvictionList());
        cacheLRU.putValue(7, 'G');
        System.out.println(cacheLRU.getData());
        System.out.println(cacheLRU.getEvictionList());


        Cache cacheMRU = cacheFactory.initCache(CacheEvictionPolicies.MRU.name()).getCache();
        cacheMRU.putValue(1, 'A');
        System.out.println(cacheMRU.getData());
        System.out.println(cacheMRU.getEvictionList());
        cacheMRU.putValue(2, 'B');
        System.out.println(cacheMRU.getData());
        System.out.println(cacheMRU.getEvictionList());
        cacheMRU.putValue(3, 'C');
        System.out.println(cacheMRU.getData());
        System.out.println(cacheMRU.getEvictionList());
        cacheMRU.putValue(4, 'D');
        System.out.println(cacheMRU.getData());
        System.out.println(cacheMRU.getEvictionList());
        cacheMRU.putValue(5, 'E');
        System.out.println(cacheMRU.getData());
        System.out.println(cacheMRU.getEvictionList());
        cacheMRU.putValue(6, 'F');
        System.out.println(cacheMRU.getData());
        System.out.println(cacheMRU.getEvictionList());
        cacheMRU.putValue(3, 'C');
        System.out.println(cacheMRU.getData());
        System.out.println(cacheMRU.getEvictionList());
        cacheMRU.putValue(7, 'G');
        System.out.println(cacheMRU.getData());
        System.out.println(cacheMRU.getEvictionList());
        cacheMRU.putValue(2, 'B');
        System.out.println(cacheMRU.getData());
        System.out.println(cacheMRU.getEvictionList());


    }
}
