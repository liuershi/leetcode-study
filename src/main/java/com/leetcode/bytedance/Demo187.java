package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/7/30 6:52 下午
 * @Version 1.0
 */
public class Demo187 {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> rsp = new ArrayList<>();
        int len = s.length();
        Map<String, Integer> map = new HashMap<>(len);
        for (int i = 0; i + 10 <= len; i++) {
            String str = s.substring(i, i + 10);
            int count = map.getOrDefault(str, 0);
            if (count == 1) rsp.add(str);
            map.put(str, count + 1);
        }
        return rsp;
    }
}
