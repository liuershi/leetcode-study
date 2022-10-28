package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/10/24 6:47 下午
 * @Version 1.0
 */
public class Demo915 {

    public int partitionDisjoint(int[] nums) {
        // 思路：一次遍历
        int leftPos = 0, leftMax = nums[0], curMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (leftMax > nums[i]) {
                leftPos = i;
                leftMax = curMax;
            }
        }
        return leftPos + 1;
    }
}
