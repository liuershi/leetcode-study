package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/11/8 11:31 下午
 * @Version 1.0
 */
public class Demo740 {

    public int deleteAndEarn(int[] nums) {
        // 思路：将每个数对应的数值和计算出来，转换为打家劫舍问题
        int n = 10001;
        int[] trans = new int[n];
        for (int val : nums) trans[val] += val;

        int[] memo = new int[n];
        memo[0] = 0;
        memo[1] = trans[1];
        for (int i = 2; i < n; i++) {
            memo[i] = Math.max(memo[i - 1], memo[i - 2] + trans[i]);
        }
        return memo[memo.length - 1];
    }
}
