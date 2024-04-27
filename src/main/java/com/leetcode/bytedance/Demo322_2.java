package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author fishball
 * @Date 2024/3/24 6:39 上午
 * @Version 1.0
 */
public class Demo322_2 {

    int[] cache;
    public int coinChange(int[] coins, int amount) {
        this.cache = new int[amount + 1];
        Arrays.fill(cache, -1);
        return process(coins, amount);
    }

    private int process(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (cache[amount] != -1) {
            return cache[amount];
        }

        int val = Integer.MAX_VALUE;
        for (int coin : coins) {
            int remain = process(coins, amount - coin);
            if (remain < 0) {
                continue;
            }
            val = Math.min(val, remain + 1);
        }

        cache[amount] = val == Integer.MAX_VALUE ? -1 : val;

        return cache[amount];
    }
}
