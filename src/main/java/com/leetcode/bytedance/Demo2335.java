package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2023/2/11 2:57 下午
 * @Version 1.0
 */
public class Demo2335 {

    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int sum = amount[0] + amount[1];
        if (sum > amount[2]) {
            int val = amount[2];
            val += (sum - amount[2]) >> 1;
            if ((sum - amount[2]) % 2 != 0) {
                val++;
            }
            return val;
        } else if (sum == amount[2]) {
            return sum;
        } else {
            return amount[2];
        }
    }
}
