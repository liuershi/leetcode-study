package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/27 4:06 下午
 * @Version 1.0
 */
public class Offer14I {

    public int cuttingRope(int n) {
        // 思路：可打印 2 - 10 直接数对于的规律
        int[] nums = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (i < 4) nums[i] = i - 1;
            else {
                nums[i] = Math.max(2 * (i - 2), 2 * nums[i - 2]);
                if (i >= 5) {
                    int max = Math.max(nums[i - 3] * 3, 3 * (i - 3));
                    nums[i] = Math.max(nums[i], max);
                }
            }
        }
        return nums[n];
    }
}
