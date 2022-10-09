package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/10/9 10:56 下午
 * @Version 1.0
 */
public class Demo459 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int rps = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            rps += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }
        return rps;
    }
}
