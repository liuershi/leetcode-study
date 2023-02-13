package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2023/2/4 10:04 下午
 * @Version 1.0
 */
public class Demo1798 {

    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);

        int res = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > res + 1)
                break;
            res += coins[i];
        }
        return res;
    }
}
