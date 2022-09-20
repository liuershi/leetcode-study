package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/29 12:17 上午
 * @Version 1.0
 */
public class Demo1470 {

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        for (int i = 0; i < n; i++) {
            res[i << 1] = nums[i];
            res[(i << 1) + 1] = nums[i + n];
        }
        return res;
    }
}
