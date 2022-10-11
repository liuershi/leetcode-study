package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/10/11 10:17 下午
 * @Version 1.0
 */
public class Demo1790 {

    public boolean areAlmostEqual(String s1, String s2) {
        // 思路：
        // 1.使用数组记录判断两个字符串的字符是否相等
        // 2.判断相同下标的字符数是否小于2
        int len = s1.length(), diff = 0;
        int[] memo = new int[26];
        for (int i = 0; i < len; i++) {
            memo[s1.charAt(i) - 'a']++;
            if (s1.charAt(i) != s2.charAt(i)) {
                if (++diff > 2) return false;
            }
        }
        for (char c : s2.toCharArray())
            if (--memo[c - 'a'] < 0) return false;
        return true;
    }
}
