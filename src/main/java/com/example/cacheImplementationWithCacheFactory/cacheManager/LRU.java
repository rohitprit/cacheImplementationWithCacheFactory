package com.example.cacheImplementationWithCacheFactory.cacheManager;

public class LRU<K, V> extends Cache<K, V> {

    public LRU(int sizeOfCache) {
        super(sizeOfCache, CacheEvictionPolicies.LRU);
    }

    @Override
    public V getValue(K key) {
        boolean remove = this.evictionList.remove(key);
        if(remove) {
            this.evictionList.addFirst(key);
            return data.get(key);
        }
        return null;
    }

    @Override
    public Cache<K, V> putValue(K key, V value) {
        if(this.data.containsKey(key)){
            this.evictionList.remove(key);
            this.data.remove(key);
        }
        if(isCacheFull()) {
            dataEviction();
        }
        this.evictionList.addFirst(key);
        this.data.put(key, value);
        return this;
    }

}