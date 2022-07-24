package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/24 4:43 下午
 * @Version 1.0
 */
public class Demo152 {

    public int maxProduct(int[] nums) {
        int curMax = nums[0], curMin = nums[0];
        int rsp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }
            curMax = Math.max(curMax * nums[i], nums[i]);
            curMin = Math.min(curMin * nums[i], nums[i]);
            rsp = Math.max(rsp, curMax);
        }
        return rsp;
    }
}
