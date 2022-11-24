package com.leetcode.weekly.week320;

/**
 * @Author milindeyu
 * @Date 2022/11/20 10:32 上午
 * @Version 1.0
 */
public class Demo6241 {

    public int unequalTriplets(int[] nums) {
        int rsp = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j])
                    continue;
                for (int k = j + 1; k < n; k++) {
                    if (nums[j] == nums[k] || nums[k] == nums[i])
                        continue;
                    rsp++;
                }
            }
        }
        return rsp;
    }
}
