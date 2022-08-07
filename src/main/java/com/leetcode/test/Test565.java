package com.leetcode.test;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/7/17 5:11 下午
 * @Version 1.0
 */
public class Test565 {

    public int arrayNesting(int[] nums) {
        int len = 0;
        if (nums == null || (len = nums.length) < 2) return len;

        boolean[] visitor = new boolean[len];
        int rsp = 0;
        for (int i = 0; i < len; i++) {
            if (visitor[i]) continue;
            int index = nums[i], count = 0;
            while (!visitor[index]) {
                visitor[index] = true;
                count++;
                index = nums[index];
            }
            rsp = Math.max(rsp, count);
        }
        return rsp;
    }
}
