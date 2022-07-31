package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.Map;

/**
 * 有序数组的平方
 *
 * @Author milindeyu
 * @Date 2022/7/31 11:41 下午
 * @Version 1.0
 */
public class Demo977 {

    public int[] sortedSquares(int[] nums) {
//        return method1(nums);
        // 基于双指针，用空间换时间
        int[] rsp = new int[nums.length];
        int left = 0, right = nums.length - 1, index = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                rsp[index--] = nums[left] * nums[left++];
            } else
                rsp[index--] = nums[right] * nums[right--];
        }
        return rsp;
    }

    /**
     * 先赋值后排序
     *  时间复杂度：O(n + nlogn)
     * @param nums
     * @return
     */
    private int[] method1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
