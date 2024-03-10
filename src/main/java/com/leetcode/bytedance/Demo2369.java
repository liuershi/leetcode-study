package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2024/3/1 11:53 下午
 * @Version 1.0
 */
public class Demo2369 {

    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            dp[i + 1] =
                    (dp[i - 1] && nums[i - 1] == nums[i])
                    ||
                    (i > 1 && dp[i - 2] && (
                            (nums[i - 2] == nums[i - 1] && nums[i - 1] == nums[i])
                                ||
                            (nums[i - 2] + 1 == nums[i - 1] && nums[i - 1] + 1 == nums[i])
                    ));
        }

        return dp[n];
    }
}
