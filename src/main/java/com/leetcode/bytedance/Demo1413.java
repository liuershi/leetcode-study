package com.leetcode.bytedance;

/**
 * https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/
 *
 * 每日一题
 *
 * @Author milindeyu
 * @Date 2022/8/9 11:28 下午
 * @Version 1.0
 */
public class Demo1413 {

    public int minStartValue(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int cur = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur += nums[i];
            min = Math.min(min, cur);
        }
        return min < 0 ? -min + 1 : 1;
    }
}
