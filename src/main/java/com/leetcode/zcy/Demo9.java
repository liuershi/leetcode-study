package com.leetcode.zcy;

import java.util.PriorityQueue;

/**
 * @Author milindeyu
 * @Date 2022/3/30 11:22 下午
 * @Version 1.0
 */
public class Demo9 {

    /**
     * 使用哈夫曼编码解决下列问题
     *      问题：给定一个数组，里面是需要得到的金条长度，例如[10, 20, 30]，则此时金条的总长度
     *      为60，将长度60的金条切分成数组中各金条长度，同时每切割时，需要花费当前金条长度的金币，
     *      例如第一次切成10和50，此时需花费60金币，第二次将50切为20和30需花费650金币，则总共花费
     *      60+50=110金币，求出怎么切花费的金币最少。（也是贪心算法实现）
     * @param arr
     * @return
     */
    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // 先将元素全部存入小根堆
        for (int i : arr) {
            queue.add(i);
        }

        int sum = 0;
        int cur;
        while (queue.size() > 1) {
            // 每次取两个元素相加入堆
            cur = queue.poll() + queue.poll();
            sum += cur;
            // 相加后元素再入堆
            queue.add(cur);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(lessMoney(new int[]{1, 4, 7, 2, 8, 2, 9}));
    }
}
