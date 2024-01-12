package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2024/1/12 10:01 下午
 * @Version 1.0
 */
public class Demo2085 {

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> container = new HashMap<>();
        for (String word : words1) {
            container.put(word, container.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            container.put(word, container.getOrDefault(word, 0) + 2000);
        }
        int count = 0;
        for (Integer val : container.values()) {
            if (val == 2001) {
                count++;
            }
        }
        return count;
    }
}
