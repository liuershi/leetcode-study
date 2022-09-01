package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/9/1 11:14 下午
 * @Version 1.0
 */
public class Demo1004 {

    public int longestOnes(int[] nums, int k) {
        int n = 0;
        if (nums == null || (n = nums.length) <= k) return n;

        int left = 0, right = 0, res = 0;
        while (right < n) {
            if (nums[right] == 1 || k > 0) {
                res = Math.max(res, right - left + 1);
                if (nums[right] == 0) k--;
                right++;
                continue;
            }
            if (nums[left++] == 0) k++;
            if (res >= n - left) break;
        }
        return res;
    }
}
