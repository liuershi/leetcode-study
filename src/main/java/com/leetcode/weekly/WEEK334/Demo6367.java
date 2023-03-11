package com.leetcode.weekly.WEEK334;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author milindeyu
 * @Date 2023/2/26 11:17 上午
 * @Version 1.0
 */
public class Demo6367 {

    public static int maxNumOfMarkedIndices(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n / 2; i++) {
            nums[i] = nums[i] * 2;
        }

        int count = 0;
        int left = 0, mid = n / 2, right = n / 2;
        while (left < mid && right < n) {
            if (nums[left] <= nums[right]) {
               count += 2;
               left++;
               right++;
            } else {
                right++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {57,40,57,51,90,51,68,100,24,39,11,85,2,22,67,29,74,82,10,96,14,35,25,76,26,54,29,44,63,49,73,50,95,89,43,62,24,88,88,36,6,16,14,2,42,42,60,25,4,58,23,22,27,26,3,79,64,20,92};
        System.out.println(nums.length);
        System.out.println(maxNumOfMarkedIndices(nums));
    }
}
