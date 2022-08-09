package com.leetcode.oneTest;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/7/10 3:31 下午
 * @Version 1.0
 */
public class Demo70 {

    public int climbStairs(int n) {
        if (n < 0) throw new IllegalArgumentException();
        if (n < 2) return n;
        int cache[] = new int[n + 1];
        Arrays.fill(cache, -1);
        return helper(cache, n);
    }

    private int helper(int[] cache, int n) {
        if (n <= 0) return n == 0 ? 1 : 0;
        if (cache[n] != -1) return cache[n];

        cache[n] = helper(cache, n - 1) + helper(cache, n - 2);
        return cache[n];
    }


    /**
     * 降低空间复杂度实现
     * @param n
     * @return
     */
    public int climbStairsTwo(int n) {

        int prev, post = 0, rsp = 1;
        for (int i = 0; i < n; i++) {
            prev = post;
            post = rsp;
            rsp = prev + post;
        }
        return rsp;
    }
}
