package com.iweb.homework.test31;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author wmn
 * @date 2023/11/24 22:39
 */
public class TestHashMap<K,V> implements TestMap<K,V> {
    ArrayList<LinkedList<TestEntry<K,V>>>
            list = new ArrayList<>(2000);
    public TestHashMap(){
        for (int i = 0; i < 2000; i++) {
            list.add(null);
        }
    }

    @Override
    public V put(K key, V value) {
        int hashcode = key.hashCode()%2000;
        LinkedList<TestEntry<K,V>> linkedList = list.get(hashcode);
        if(linkedList == null){
            list.set(hashcode,new LinkedList<TestEntry<K,V>>());
            TestEntry<K,V> entry = new TestEntry<>(key,value);
            list.get(hashcode).add(entry);
            return value;
        }else {
            for (TestEntry<K,V> entry:linkedList) {
                if(entry.getKey().equals(key)){
                    entry.setValue(value);
                    return value;
                }
            }
        }
        TestEntry<K,V> entry = new TestEntry<>(key,value);
        linkedList.add(entry);
        return value;
    }

    @Override
    public V get(Object key) {
        if(key == null){
            return null;
        }
        int hashcode = key.hashCode()%2000;
        //根据hashcode找到对应链表
        LinkedList<TestEntry<K,V>> linkedList
                =list.get(hashcode);
        //如果链表为空
        if(linkedList == null){
            //对应键值对不存在
            return null;
        }else {
            for (TestEntry<K,V> entry: linkedList) {
                if(key.equals(entry.getKey())){
                    return entry.getValue();
                }
            }
        }
        return null;
    }
}
