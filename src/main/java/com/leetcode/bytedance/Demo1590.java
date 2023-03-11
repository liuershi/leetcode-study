package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/3/10 9:58 下午
 * @Version 1.0
 */
public class Demo1590 {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1];
        }
        if (prefixSum[n] % p == 0) {
            return 0;
        }

        for (int i = 1; i < n; i++) {
            for (int left = 0, right = i; right <= n; right++, left++) {
                long remain = prefixSum[n] - (prefixSum[right] - prefixSum[left]);
                if (remain % p == 0) {
                    return right - left;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Demo1590 demo1590 = new Demo1590();
        int[] nums ={3,1,4,2};
        System.out.println(demo1590.minSubarray(nums, 6));
    }
}
