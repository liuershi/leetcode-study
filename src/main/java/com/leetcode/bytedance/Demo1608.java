package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/9/12 9:58 下午
 * @Version 1.0
 */
public class Demo1608 {

    public int specialArray(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (nums[j] >= i) count++;
            }
            if (count == i) return count;
        }
        return -1;
    }
}
