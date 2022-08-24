package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/23 12:05 上午
 * @Version 1.0
 */
public class Demo343 {

    public int integerBreak(int n) {
        int[] nums = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (i <= 3) nums[i] = i - 1;
            else{
                nums[i] = Math.max(nums[i - 2], i - 2) * (i - 2);
                if (i >= 5) {
                    nums[i] = Math.max(nums[i], Math.max(nums[i - 3], i - 3) * (i - 3));
                }
            }
        }
        return nums[n];
    }
}
