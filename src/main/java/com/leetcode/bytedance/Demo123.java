package com.leetcode.bytedance;


/**
 * @author zhangwei151
 * @date 2022/6/3 20:56
 */
public class Demo123 {


    public int maxProfit(int[] prices) {
//        return f(prices, 0, 0, 0);
        int len = prices.length;
        int buy1 = -prices[0],
                sell1 = 0,
                buy2 = -prices[0],
                sell2 = 0;

        for (int i = 1; i < len; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    /**
     * 暴力递归（会超时）
     * @param prices
     * @param day 当前天
     * @param hasStock 手中是否有股票
     * @param counts 进行交易的次数
     * @return
     */
    public int f(int[] prices, int day, int hasStock, int counts) {
        if (day >= prices.length || (counts >= 2 && hasStock < 1))
            return 0;

        if (hasStock > 0)
            return Math.max(prices[day] + f(prices, day + 1, 0, counts), f(prices, day + 1, 1, counts));

        return Math.max(
                -prices[day] + f(prices, day + 1, 1, counts + 1),
                f(prices, day + 1, 0, counts)
        );
    }
}
