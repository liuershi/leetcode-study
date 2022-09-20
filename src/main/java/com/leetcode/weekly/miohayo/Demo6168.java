package com.leetcode.weekly.miohayo;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/9/4 10:47 上午
 * @Version 1.0
 */
public class Demo6168 {

    long divisor;
    public int numberOfWays(int startPos, int endPos, int k) {
        divisor = (long) (1e9 + 7);
        int[][] cache = new int[3000][k + 1];
        for (int i = 0; i < 3000; i++) {
            Arrays.fill(cache[i], -1);
        }
        return helper(k, startPos, endPos, cache);
    }

    private int helper(int rest, int startPos, int endPos, int[][] cache) {
        if (cache[startPos + 1000][rest] != -1)
            return cache[startPos + 1000][rest];
        if (rest == 0) return startPos == endPos ? 1 : 0;

        int left = helper(rest - 1, startPos + 1, endPos, cache);
        int right = helper(rest - 1, startPos + 1, endPos, cache);
        cache[startPos + 1000][rest] = (int) ((left + right) % divisor);
        return cache[startPos + 1000][rest];
    }
}
