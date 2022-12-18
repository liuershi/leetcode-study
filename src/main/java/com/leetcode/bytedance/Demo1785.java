package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author milindeyu
 * @Date 2022/12/16 10:39 下午
 * @Version 1.0
 */
public class Demo1785 {

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        long diff = Math.abs(sum - goal);
        long res = diff / limit;
        if (diff % limit != 0) {
            res++;
        }
        return (int) res;
    }
}
