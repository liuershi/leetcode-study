package com.leetcode.zcy;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/4/30 6:44 下午
 * @Version 1.0
 */
public class Demo24 {

    /**
     * 有一个数组nums，里面每个元素是硬币的面值，存在重复面值，给定一个金额balance，求出
     * 最少数组中能加起来和为指定金额的最少硬币数.
     *
     * 例如：数组 nums = {2, 3, 1, 7 , 5, 3}，指定金额为10， 则组成金额10的最少硬币为3和7，所以最少硬币数为2
     */

    /**
     * 递归，对于每个硬币，都有是否选择的情况，分别递归判断
     * @param nums
     * @param balance
     * @return
     */
    public static int minCoin(int[] nums, int balance) {
        int[][] cache = new int[nums.length + 1][balance + 1];
        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= balance; j++) {
                cache[i][j] = -2;
            }
        }
        return process(nums, 0, balance, cache);
    }

    private static int process(int[] nums, int index, int balance, int[][] cache) {
        // 此时剩余金额数小于0，则此种情况不符合
        if (balance < 0) {
            return -1;
        }

        // 检查缓存
        if (cache[index][balance] != -2) {
            return cache[index][balance];
        }

        if (balance == 0) {
            // 金额刚好为0，说明此时之前加起来的硬币数刚刚好，返回0即可
            cache[index][balance] = 0;
        } else if (index == nums.length) {
            // 此时说明金额还有剩余且无可选择的硬币了，那么此时也无法找到选择
            cache[index][balance] = -1;
        } else {
            // 此时可以选择硬币或不选择硬币
            int noSelected = process(nums, index + 1, balance, cache);
            int selected = process(nums, index + 1, balance - nums[index], cache);

            if (noSelected < 0 && selected < 0) {
                // 说明此时不管是选不选择硬币都无法凑成金额balance
                cache[index][balance] = -1;
            } else {
                if (noSelected < 0) {
                    cache[index][balance] = selected + 1;
                } else if (selected < 0) {
                    cache[index][balance] = noSelected;
                } else {
                    cache[index][balance] = Math.min(noSelected, selected + 1);
                }
            }
        }


        return cache[index][balance];
    }


    /**
     * 方式二，使用动态规划的方式实现
     * @param nums
     * @param balance
     * @return
     */
    public static int minCoin2(int[] nums, int balance) {
        int n = nums.length;
        int[][] dp = new int[n + 1][balance + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= balance; i++) {
            dp[n][i] = -1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= balance; j++) {
                int noSelected = dp[i + 1][j];
                int selected = -1;
                if (j - nums[i] >= 0)    {
                    selected = dp[i + 1][j - nums[i]];
                }
                if (noSelected < 0 && selected < 0) {
                    dp[i][j] = -1;
                } else if (noSelected < 0){
                    dp[i][j] = selected + 1;
                } else if (selected < 0) {
                    dp[i][j] = noSelected;
                } else {
                    dp[i][j] = Math.min(selected + 1, noSelected);
                }
            }
        }
        return dp[0][balance];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 7 , 5, 3};
        int balance = 5;
        System.out.println(minCoin(nums, balance));
        System.out.println(minCoin2(nums, balance));
    }
}
