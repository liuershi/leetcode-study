package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @author zhangwei151
 * @date 2022/9/24 21:35
 */
public class Offer61 {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] > 0) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - nums[i - 1] != 1) return false;
            }
        } else {
            int zeroNum = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0) zeroNum++;
                else {
                    if (nums[i - 1] != 0 && nums[i] - nums[i - 1] != 1) {
                        zeroNum -= nums[i] - nums[i - 1] - 1;
                    }
                    if (zeroNum < 0 || nums[i] == nums[i - 1]) return false;
                }
            }
        }
        return true;
    }
}
