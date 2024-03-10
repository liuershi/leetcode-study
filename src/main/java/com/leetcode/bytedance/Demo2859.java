package com.leetcode.bytedance;

import java.util.List;

/**
 * @Author milindeyu
 * @Date 2024/1/25 10:42 下午
 * @Version 1.0
 */
public class Demo2859 {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        if (k == 0) {
            return nums.get(0);
        }
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            int bit = 0;
            int val = i;
            while (val > 0) {
                bit += val & 1;
                val >>>= 1;
            }
            if (bit == k) {
                count += nums.get(i);
            }
        }
        return count;
    }
}
