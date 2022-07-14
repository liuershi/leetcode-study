package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/7/13 7:09 下午
 * @Version 1.0
 */
public class Demo242 {

    public boolean isAnagram(String s, String t) {
//        return method1(s, t);

        if (s.length() != t.length()) return false;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        return Arrays.equals(cs, ct);
    }

    private boolean method1(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen) return false;
        int[] nums = new int[26];
        for (int i = 0; i < sLen; i++) {
            nums[s.charAt(i) - 97]++;
            nums[t.charAt(i) - 97]--;
        }
        for (int num : nums) {
            if (num != 0) return false;
        }
        return true;
    }
}
