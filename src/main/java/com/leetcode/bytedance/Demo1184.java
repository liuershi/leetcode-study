package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/24 12:03 上午
 * @Version 1.0
 */
public class Demo1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int min = Math.min(start, destination);
        int max = Math.max(start, destination);
        int totalSum = 0;
        int sum = 0;
        for (int i = 0; i < distance.length; i++) {
            totalSum += distance[i];
            if (i >= min && i < max) sum += distance[i];
        }
        return Math.min(totalSum - sum, sum);
    }
}
