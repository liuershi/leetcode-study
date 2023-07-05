package com.leetcode.top100;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2023/6/24 9:17 下午
 * @Version 1.0
 */
public class Demo49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> container = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!container.containsKey(key)) {
                container.put(key, new ArrayList<>());
            }
            container.get(key).add(str);
        }

        return new ArrayList<>(container.values());
    }
}
