package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/3/31 9:09 下午
 * @Version 1.0
 */
public class Demo2367 {

    public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length, count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int val = nums[j] - nums[i];
                if (val < diff) {
                    continue;
                } else if (val > diff) {
                    break;
                }
                for (int k = j + 1; k < n; k++) {
                    val = nums[k] - nums[j];
                    if (val > diff) {
                        break;
                    } else if (val == diff) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
