package com.leetcode.bytedance;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/12/12 12:07 上午
 * @Version 1.0
 */
public class Demo1781 {

    public int beautySum(String s) {
        int sum = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            int[] memo = new int[26];
            for (int j = i; j < s.length(); j++) {
                memo[s.charAt(j) - 'a']++;
                int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                for (int val : memo) {
                    max = Math.max(max, val);
                    min = Math.min(min, val);
                }
                sum += max - min;
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        int val = 1 << 14;
        System.out.println(val);
    }
}
