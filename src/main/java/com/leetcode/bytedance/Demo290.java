package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/7/13 10:48 下午
 * @Version 1.0
 */
public class Demo290 {

    public boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
        if (pattern.length() != ss.length) return false;
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map1 = new HashMap<>();
        char[] chars = pattern.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char val = chars[i];
            if (map.containsKey(val) && !map.get(val).equals(ss[i])) return false;
            if (map1.containsKey(ss[i]) && map1.get(ss[i]) != val) return false;
            map.put(val, ss[i]);
            map1.put(ss[i], val);
        }
        return true;
    }
}
