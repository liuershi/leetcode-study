package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/12/13 1:09 上午
 * @Version 1.0
 */
public class Demo2697 {

    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length, len = n >> 1;
        for (int i = 0; i < len; i++) {
            if (chars[i] < chars[n - i - 1]) {
                chars[n - i - 1] = chars[i];
            } else {
                chars[i] = chars[n - i - 1];
            }
        }

        return new String(chars);
    }
}
