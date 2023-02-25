package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2023/2/25 10:27 下午
 * @Version 1.0
 */
public class Demo1247 {

    public int minimumSwap(String s1, String s2) {
        int[] memo = new int[2];
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                memo[s1.charAt(i) & 1]++;
            }
        }

        int diff = memo[0] + memo[1];

        return ((diff & 1) == 1) ?  -1 : diff / 2 + memo[0] % 2;
    }
}
