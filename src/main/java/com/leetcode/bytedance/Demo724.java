package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/9/2 11:52 下午
 * @Version 1.0
 */
public class Demo724 {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        // if (sum == 0) return 0;

        int res = -1, prevSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * prevSum + nums[i] == sum) {
                res = i;
                break;
            }
            prevSum += nums[i];
        }
        return res;
    }

}
