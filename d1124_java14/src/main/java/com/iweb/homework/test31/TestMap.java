package com.iweb.homework.test31;

/**
 * @author wmn
 * @date 2023/11/24 22:38
 */
public interface TestMap<K,V> {
    V put(K key,V value);
    V get(Object key);
}
