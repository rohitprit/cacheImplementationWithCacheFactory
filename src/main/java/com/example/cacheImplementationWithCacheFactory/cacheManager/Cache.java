package com.example.cacheImplementationWithCacheFactory.cacheManager;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public abstract class Cache<K, V> {

    int sizeOfCache = 0;
    HashMap<K, V> data = null;
    LinkedList<K> evictionList = null;
    String policyName=null;

    public abstract V getValue(K key);
    public abstract Cache<K, V> putValue(K key, V value);

    public Cache(int sizeOfCache, CacheEvictionPolicies policy){
        this.sizeOfCache = sizeOfCache;
        data = new HashMap<>(sizeOfCache);
        evictionList = new LinkedList<>();
        policyName = policy.name();
    }

    void dataEviction() throws NoSuchElementException {
        K key = evictionList.removeLast();
        data.remove(key);
    }

    boolean isCacheFull() {
        return data.size() == sizeOfCache;
    }

    void invalidate(K key) {
        this.data.remove(key);
        this.evictionList.remove(key);
    }

    void cacheClean() {
        evictionList.clear();
        data.clear();
    }

    public HashMap<K, V> getData() {
        return data;
    }

    public LinkedList<K> getEvictionList(){
        return evictionList;
    }
}