package com.example.cacheImplementationWithCacheFactory.cacheManager;

public class CacheFactory<K, V> {
    @SuppressWarnings("rawtypes")
    private static volatile CacheFactory cacheFactory = null;
    private int DEFAULT_CACHE_SIZE = 10 * 1024 * 1024;
    private Cache<K, V> cache = null;

    private CacheFactory() {
    }

    private CacheFactory(int size) {
        DEFAULT_CACHE_SIZE = size;
    }

    public static <K, V> CacheFactory<K, V> getInstance() {
        if (cacheFactory == null) {
            synchronized (CacheFactory.class) {
                if (cacheFactory == null)
                    cacheFactory = new CacheFactory<K, V>();
            }
        }
        return cacheFactory;
    }

    public static <K, V> CacheFactory<K, V> getInstance(int cacheSize) {
        if (cacheFactory == null) {
            synchronized (CacheFactory.class) {
                if (cacheFactory == null)
                    cacheFactory = new CacheFactory<K, V>(cacheSize);
            }
        }
        return cacheFactory;
    }

    public CacheFactory<K, V> initCache(String policy) {
        if (CacheEvictionPolicies.LRU.name().equalsIgnoreCase(policy))
            cache = new LRU<K, V>(DEFAULT_CACHE_SIZE);
        else if (CacheEvictionPolicies.MRU.name().equalsIgnoreCase(policy))
            cache = new MRU<K, V>(DEFAULT_CACHE_SIZE);
        else
            throw new IllegalArgumentException("Invalid Eviction policy");
        return cacheFactory;
    }

    public Cache<K, V> getCache() {
        return cache;
    }

}