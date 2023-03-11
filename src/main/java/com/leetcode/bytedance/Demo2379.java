package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/3/9 9:45 下午
 * @Version 1.0
 */
public class Demo2379 {

    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int left = 0, right = k;
        int[] memo = new int[2];
        for (int i = 0; i < right; i++) {
            memo[blocks.charAt(i) & 1]++;
        }
        int res = memo[1];
        while (right < n) {
            memo[blocks.charAt(left++) & 1]--;
            memo[blocks.charAt(right++) & 1]++;
            res = Math.min(memo[1], res);
        }
        return res;
    }
}
