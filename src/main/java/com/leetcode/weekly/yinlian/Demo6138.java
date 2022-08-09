package com.leetcode.weekly.yinlian;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/8/7 5:01 下午
 * @Version 1.0
 */
public class Demo6138 {

    public int longestIdealString(String s, int k) {
        int[] memo = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            for (int j = Math.max(index - k, 0); j <= Math.min(index + k, 25); j++) {
                memo[index] = Math.max(memo[index], memo[j]);
            }
            memo[index]++;
        }
        return Arrays.stream(memo).max().getAsInt();
    }
}
