package com.leetcode.weekly.twoweek.week85;

/**
 * @Author milindeyu
 * @Date 2022/8/20 11:52 下午
 * @Version 1.0
 */
public class Demo6159 {

    int[] nums;
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        this.nums = nums;
        long[] res = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums[removeQueries[i]] = 0;
            res[i] = Math.max(helper(0, removeQueries[i]), helper(removeQueries[i] + 1, nums.length));
        }
        return res;
    }

    private long helper(int left, int right) {
        long sum = 0;
        for (int i = left; i < right; i++) {
            sum += nums[i];
        }
        return sum;
    }

}
