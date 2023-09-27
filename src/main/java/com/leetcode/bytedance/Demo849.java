package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/8/22 12:56 上午
 * @Version 1.0
 */
public class Demo849 {

    public int maxDistToClosest(int[] seats) {
        int max = 0;
        int left = 0;
        while (left < seats.length && seats[left] == 0) {
            left++;
        }

        max = left;

        while (left < seats.length) {
            int right = left + 1;
            while (right < seats.length && seats[right] == 0) {
                right++;
            }

            if (right == seats.length) {
                max = Math.max(max, right - left - 1);
            } else {
                max = Math.max(max, (right - left) / 2);
            }

            left = right;
        }

        return max;
    }
}
