package com.leetcode.bytedance;

import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/3/19 5:34 下午
 * @Version 1.0
 */
public class Demo121 {
    public static void main(String[] args) {
        Demo121 demo121 = new Demo121();
        System.out.println(demo121.maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {

        int min = prices[0], max = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            max = Math.max(max, price - min);
        }
        return max;
    }
}
