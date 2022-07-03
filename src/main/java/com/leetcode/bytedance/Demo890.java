package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/6/12 12:06 上午
 * @Version 1.0
 */
public class Demo890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> rsp = new ArrayList<>();
        Map<Character, Character> map = new HashMap<>(pattern.length());
        for (String word : words) {
            if (matcher(word, pattern, map) && matcher(pattern, word, map)) rsp.add(word);
        }
        return rsp;
    }

    public boolean matcher(String word, String pattern, Map<Character, Character> map) {
        map.clear();
        for (int i = 0; i < word.length(); i++) {
            map.putIfAbsent(pattern.charAt(i), word.charAt(i));
            if (map.get(pattern.charAt(i)) != word.charAt(i)) return false;
        }
        return true;
    }
}
