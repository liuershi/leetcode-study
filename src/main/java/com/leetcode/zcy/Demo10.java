package com.leetcode.zcy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author milindeyu
 * @Date 2022/3/30 11:40 下午
 * @Version 1.0
 */
public class Demo10 {

    static class Business {
        // 开销
        int spend;
        // 利润
        int profit;

        public Business(int spend, int profit) {
            this.spend = spend;
            this.profit = profit;
        }
    }

    static class MinHeapComparator implements Comparator<Business> {
        @Override
        public int compare(Business o1, Business o2) {
            return o1.spend - o2.spend;
        }
    }

    static class MaxHeapComparator implements Comparator<Business> {
        @Override
        public int compare(Business o1, Business o2) {
            return o2.profit - o1.profit;
        }
    }


    /**
     * 给定一系列生意，指定允许做生意的数量，指定初始资金，怎么才能获取最大利润
     * @param num 允许做生意数量
     * @param money 初始资金
     * @param businesses 所有生意
     * @return
     */
    public static int businessMoney(int num, int money, Business[] businesses) {
        // 创建一个小根堆，按开销来排序
        PriorityQueue<Business> minQueue = new PriorityQueue<>(new MinHeapComparator());
        minQueue.addAll(Arrays.asList(businesses));
        // 创建一个大根堆，按照利润来排序
        PriorityQueue<Business> maxQueue = new PriorityQueue<>(new MaxHeapComparator());

        // 循环允许的次数
        for (int i = 0; i < num; i++) {
            while (!minQueue.isEmpty() && minQueue.peek().spend <= money) {
                maxQueue.add(minQueue.poll());
            }
            if (maxQueue.isEmpty())
                return money; // 此时说明当前资金不够做任何生意

            money += maxQueue.poll().profit;
        }

        return money;
    }

    public static void main(String[] args) {
        Business[] businesses = {
                new Business(1, 2),
                new Business(3, 5),
                new Business(4, 7),
                new Business(5, 10),
                new Business(2, 3),
                new Business(4, 6)
        };

        System.out.println(businessMoney(4, 1, businesses));
    }
}
