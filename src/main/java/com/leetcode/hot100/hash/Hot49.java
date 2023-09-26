package com.leetcode.hot100.hash;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2023/9/26 9:58 下午
 * @Version 1.0
 */
public class Hot49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        int n = 0;
        if (strs == null || (n = strs.length) == 0) {
            return new ArrayList<>(map.values());
        }
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, key1 -> new ArrayList<String>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
