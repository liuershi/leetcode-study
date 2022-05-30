package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/3/31 10:41 下午
 * @Version 1.0
 */
public class Demo322 {

    /**
     * 用个数组作为备忘录
     */
    int[] nums;

    public int coinChange(int[] coins, int amount) {
        nums = new int[amount + 1];
        Arrays.fill(nums, -666);

        return process(coins, amount);
    }

    private int process(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        if (nums[amount] != -666) return nums[amount];

        int rsp = Integer.MAX_VALUE;
        for (int coin : coins) {

            int subProblem = process(coins, amount - coin);
            if (subProblem == -1) continue;

            rsp = Math.min(rsp, subProblem + 1);
        }
        int result = rsp == Integer.MAX_VALUE ? -1 : rsp;
        nums[amount] = result;
        return result;
    }

    public static void main(String[] args) {
        Demo322 demo322 = new Demo322();
        int[] nums = {1, 2, 5};
        System.out.println(demo322.coinChange(nums, 11));
    }
}
