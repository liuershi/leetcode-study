package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/7/13 9:38 下午
 * @Version 1.0
 */
public class Demo268 {

    public int missingNumber(int[] nums) {
//        return method01(nums);
        // O(n)的时间复杂度和O(1)的空间复杂度
        int rsp = 0;
        for (int i = 0; i < nums.length; i++) {
            rsp = rsp ^ nums[i] ^ i;
        }
        return rsp;
    }

    /**
     * 时间复杂度为 O(logn + n)
     * @param nums
     * @return
     */
    private int method01(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) return i;
        }
        return nums.length;
    }
}
