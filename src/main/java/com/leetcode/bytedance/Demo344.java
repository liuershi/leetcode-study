package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/29 10:48 下午
 * @Version 1.0
 */
public class Demo344 {

    public void reverseString(char[] s) {
        int len;
        if (s == null || (len = s.length) < 2) return;
        int count = len / 2;
        int left = 0, right = len - 1;
        while (count-- > 0) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
