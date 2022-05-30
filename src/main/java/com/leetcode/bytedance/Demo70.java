package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/5/6 12:08 上午
 * @Version 1.0
 */
public class Demo70 {

    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        return process(n, cache);
    }

    private int process(int n, int[] cache) {
        if (n <= 0)
            return n < 0 ? 0 : 1;

        if (cache[n] != -1)
            return cache[n];

        cache[n] = process(n - 1, cache) + process(n - 2, cache);

        return cache[n];
    }
}
