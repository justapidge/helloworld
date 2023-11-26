package com.iweb.homework.test31;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wmn
 * @date 2023/11/24 22:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestEntry<K,V> {
    private K key;
    private V value;
}
