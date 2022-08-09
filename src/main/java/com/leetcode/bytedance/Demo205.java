package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/7/12 10:53 下午
 * @Version 1.0
 */
public class Demo205 {

    public boolean isIsomorphic(String s, String t) {
//        return method1(s, t);
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) return false;
        }
        return true;
    }

    private boolean method1(String s, String t) {
        int len = s.length();
        Map<Character, Character> map1 = new HashMap<>(128);
        Map<Character, Character> map2 = new HashMap<>(128);
        for (int i = 0; i < len; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (map1.containsKey(sc) && map1.get(sc) != tc) return false;
            if (map2.containsKey(tc) && map2.get(tc) != sc) return false;
            map1.put(sc, tc);
            map2.put(tc, sc);
        }
        return true;
    }
}
