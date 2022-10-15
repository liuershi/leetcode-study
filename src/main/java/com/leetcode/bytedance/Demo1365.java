package com.leetcode.bytedance;


/**
 * @Author milindeyu
 * @Date 2022/10/15 8:16 下午
 * @Version 1.0
 */
public class Demo1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] memo = new int[101];
        for (int num : nums) memo[num]++;
        for (int i = 1; i < memo.length; i++) {
            memo[i] += memo[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] == 0 ? 0 : memo[nums[i] - 1];
        }
        return nums;
    }
}
