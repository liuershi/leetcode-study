package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/10/11 10:17 下午
 * @Version 1.0
 */
public class Demo1790 {

    public boolean areAlmostEqual(String s1, String s2) {
//        return method1(s1, s2);

        // 方式二：时间复杂度：O(N) 空间复杂度：O(1)
        boolean exchange = false; // 表示是否交换过
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (exchange) return false;
                int index = i + 1;
                while (index < s1.length() && s1.charAt(index) == s2.charAt(index)) {
                    index++;
                }
                if (index == s1.length()) return false;
                // 确认两个位置的字符是否能否交换
                if (s1.charAt(i) != s2.charAt(index) || s1.charAt(index) != s2.charAt(i)) return false;
                exchange = true;
                i = index;
            }
        }
        return true;
    }
    private boolean method1(String s1, String s2) {
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
