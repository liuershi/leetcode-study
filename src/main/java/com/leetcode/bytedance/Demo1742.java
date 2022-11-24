package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/11/23 10:58 下午
 * @Version 1.0
 */
public class Demo1742 {

    public int countBalls(int lowLimit, int highLimit) {
        int rsp = 0;
        // highLimit <= 10^5  故最大为 9 * 5 = 45
        int[] memo = new int[46];
        for (int i = lowLimit; i <= highLimit; i++) {
            int val = sumBaseBit(i);
            memo[val]++;
            rsp = Math.max(rsp, memo[val]);
        }
        return rsp;
    }

    private int sumBaseBit(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
