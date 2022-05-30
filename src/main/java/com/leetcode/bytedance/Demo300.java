package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/3/23 10:38 下午
 * @Version 1.0
 */
public class Demo300 {

    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];

        int len = 0;
        for (int num : nums) {
            int idx = Arrays.binarySearch(res, 0, len, num);
            idx = idx < 0 ? -idx - 1: idx;
            res[idx] = num;
            if (idx == len) {
                len++;
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 2, 3};
        Demo300 demo300 = new Demo300();
        System.out.println(demo300.lengthOfLIS(nums));
    }
}
