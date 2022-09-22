package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/27 10:13 下午
 * @Version 1.0
 */
public class Demo303 {

    class NumArray {

        int[] sumArr;

        public NumArray(int[] nums) {
            int n = nums.length;
            sumArr = new int[n];
            sumArr[0] = nums[0];
            for (int i = 1; i < n; i++) {
                sumArr[i] += sumArr[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            if (left > 0) return sumArr[right] - sumArr[left - 1];
            else return sumArr[right];
        }
    }
}
