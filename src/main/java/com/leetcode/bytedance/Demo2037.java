package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/12/31 1:32 下午
 * @Version 1.0
 */
public class Demo2037 {

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int sum = 0;
        for (int i = 0; i < seats.length; i++) {
            sum += Math.abs(seats[i] - students[i]);
        }
        return sum;
    }
}
