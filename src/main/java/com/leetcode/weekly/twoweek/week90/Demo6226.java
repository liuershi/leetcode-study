package com.leetcode.weekly.twoweek.week90;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/10/29 11:11 下午
 * @Version 1.0
 */
public class Demo6226 {

    public int destroyTargets(int[] nums, int space) {
        Arrays.sort(nums);
        int rsp = 0, max = 1;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % space == nums[i]) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
                rsp = nums[i];
            }
            if (rsp >= nums.length - i)
                break;
        }
        return rsp;
    }
}
