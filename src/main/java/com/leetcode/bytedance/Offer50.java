package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/27 10:31 下午
 * @Version 1.0
 */
public class Offer50 {

    public char firstUniqChar(String s) {
        if (s == null || "".equals(s)) return ' ';
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (nums[s.charAt(i) - 'a'] == 1) return s.charAt(i);
        }
        return ' ';
    }
}
