package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @link https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @Author milindeyu
 * @Date 2022/3/18 10:43 下午
 * @Version 1.0
 */
public class Demo3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>(s.length());
        for (int start = 0, end = 0; end < s.length(); end++) {
            char item = s.charAt(end);
            if (map.containsKey(item)) {
                start = Math.max(start, map.get(item) + 1);
            }
            max = Math.max(max, end - start + 1);
            map.put(item, end);
        }
        return max;
    }
}
