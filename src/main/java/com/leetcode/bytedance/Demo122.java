package com.leetcode.bytedance;

/**
 * @author zhangwei151
 * @date 2022/6/3 20:36
 */
public class Demo122 {

    public int maxProfit(int[] prices) {
        int min = prices[0], sum = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i - 1] > prices[i]) {
                sum += Math.abs(prices[i - 1] - min);
                min = prices[i];
            }else {
                min = Math.min(min, prices[i]);
            }
        }
        int last = prices[prices.length - 1];
        if (last > min)
            sum += Math.abs(last - min);
        return sum;
    }
}
