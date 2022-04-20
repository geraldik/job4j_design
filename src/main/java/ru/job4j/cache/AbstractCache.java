package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
            cache.put(key, new SoftReference<V>(value));
    }

    public V get(K key) {
        V rsl;
        if (cache.get(key) != null) {
            rsl = cache.get(key).get();
            if (cache.get(key).get() == null) {
                rsl = load(key);
            } else {
                rsl = cache.get(key).get();
            }
        } else {
            put(key, load(key));
            rsl = cache.get(key).get();
        }
        return rsl;
    }

    protected abstract V load(K key);

}