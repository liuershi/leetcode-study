package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/1/5 12:24 上午
 * @Version 1.0
 */
public class Demo1803 {

    public int countPairs(int[] nums, int low, int high) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int val = nums[i] ^ nums[j];
                if (val >= low && val <= high)
                    cnt++;
            }
        }
        return cnt;
    }
}
