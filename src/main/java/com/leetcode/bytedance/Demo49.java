package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/5/22 4:49 下午
 * @Version 1.0
 */
public class Demo49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rsp = new ArrayList<>();
        if (strs == null || strs.length == 0)
            return rsp;

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            map.computeIfAbsent(s, k -> new ArrayList<>());
            map.get(s).add(str);
        }
        rsp.addAll(map.values());
        return rsp;
    }
}
