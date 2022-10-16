package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/10/16 6:09 下午
 * @Version 1.0
 */
public class Demo213 {

    public int rob(int[] nums) {
        // 打家劫舍ii
        // 思路：将环拆成两个链表，分别为0～n-1，以及1～n的链表，比较两个链表的最大值
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] memo = new int[n];
        memo[0] = nums[0];
        for (int i = 1; i < n - 1; i++) {
            if (i == 1) memo[i] = Math.max(memo[i - 1], nums[i]);
            else memo[i] = Math.max(memo[i - 1], memo[i - 2] + nums[i]);
        }
        int val = memo[n - 2];
        memo[0] = nums[1];
        for (int i = 2; i < n; i++) {
            if (i == 2) memo[i - 1] = Math.max(memo[i - 2], nums[i]);
            else memo[i - 1] = Math.max(memo[i - 2], memo[i - 3] + nums[i]);
        }
        return Math.max(val, memo[n - 1]);
    }
}
