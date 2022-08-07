package com.leetcode.weekly.shenceshuju;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/8/6 10:40 下午
 * @Version 1.0
 */
public class Demo6142 {

    public long countBadPairs(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= i;
        }
        Arrays.sort(nums);
        long rsp = 0;
        for (int i = 0; i < nums.length; i++) {
            int right = i + 1;
            while (right < nums.length && nums[i] == nums[right]) {
                right++;
            }
            if (right == nums.length) break;
            rsp += nums.length - right;
        }
        return rsp;
    }

    public static void main(String[] args) {
        Demo6142 demo6142 = new Demo6142();
        int[] nums = {4,1,3,3};
        demo6142.countBadPairs(nums);
    }
}
