package com.example.cacheImplementationWithCacheFactory.cacheManager;

public class MRU<K,V> extends Cache<K, V> {

    public MRU(int sizeOfCache) {
        super(sizeOfCache, CacheEvictionPolicies.MRU);
    }

    @Override
    public V getValue(K key) {
        boolean remove = this.evictionList.remove(key);
        if(remove) {
            this.evictionList.addLast(key);
            return this.data.get(key);
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
            this.dataEviction();
        }
        this.evictionList.addLast(key);
        this.data.put(key, value);
        return this;
    }

}