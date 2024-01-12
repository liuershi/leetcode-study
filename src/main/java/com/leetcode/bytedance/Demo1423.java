package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2023/12/6 12:10 上午
 * @Version 1.0
 */
public class Demo1423 {

    public int maxScore(int[] cardPoints, int k) {
        // 思路：可以等同于，当 cardPoints.length - k 长度的子数组最小时，那么能取到最大值
        int windowSize = cardPoints.length - k;
        int sum = 0;
        for (int i = 0; i < windowSize; i++) {
            sum += cardPoints[i];
        }

        int min = sum, cur = sum;
        for (int i = windowSize; i < cardPoints.length; i++) {
            sum += cardPoints[i];
            cur += cardPoints[i] - cardPoints[i - windowSize];
            min = Math.min(min, cur);
        }

        return sum - min;
    }

    public static void main(String[] args) {
        Demo1423 demo1423 = new Demo1423();
        int[] nums = {1,2,3,4,5,6,1};
        System.out.println(demo1423.maxScore(nums, 3));
    }
}
