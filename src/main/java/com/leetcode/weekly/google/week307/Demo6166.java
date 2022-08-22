package com.leetcode.weekly.google.week307;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/8/21 11:01 上午
 * @Version 1.0
 */
public class Demo6166 {

    public static String largestPalindromic(String num) {
        char[] chars = num.toCharArray();
        Arrays.sort(chars);
        int[] nums = new int[10];
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (nums[c - '0'] != 0) {
                nums[c - '0']--;
                sb.insert(0, c).append(c);
            } else {
                nums[c - '0']++;
            }
        }

        if (sb.length() % 2 == 0) {
            for (int i = 9; i >= 0 ; i--) {
                if (nums[i] != 0) {
                    int index = sb.length() / 2;
                    sb.insert(index, i);
                    break;
                }
            }
        }
        int len = sb.length() / 2;
        for (int i = 0; i < len; i++) {
            if (sb.charAt(0) == '0') sb.deleteCharAt(0).deleteCharAt(sb.length() - 1);
        }
        return sb.length() == 0 ? num.substring(0, 1) : sb.toString();
    }
}
