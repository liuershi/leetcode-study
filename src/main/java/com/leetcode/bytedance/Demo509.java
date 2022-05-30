package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/3/31 10:09 下午
 * @Version 1.0
 */
public class Demo509 {

    /**
     * 时间复杂度高
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 使用数组作为记忆表，减少重复查询
     * @param n
     * @return
     */
    public int fibTwo(int n) {
        int[] nums = new int[n + 1];
        return help(nums, n);
    }

    private int help(int[] nums, int n) {
        if (n <= 1) return n;

        if (nums[n] != 0) return nums[n];
        nums[n] = help(nums, n - 1) + help(nums, n - 2);
        return nums[n];
    }

    /**
     * 时间复杂度低，占用空间复杂度O(n)
     * @param n
     * @return
     */
    public int fibThree(int n) {
        if (n == 0) return 0;

        int[] nums = new int[n + 1];

        nums[0] = 0;
        nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }

    /**
     * 时间复杂度低，空间复杂度也低
     * @param n
     * @return
     */
    public int fibFour(int n) {
        if (n == 0) return 0;

        // 使用两个int减小空间复杂度
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;

        int cur;
        for (int i = 2; i <= n; i++) {
            cur = dp[1];
            dp[1] = dp[0] + dp[1];
            dp[0] = cur;
        }
        return dp[1];
    }
}
