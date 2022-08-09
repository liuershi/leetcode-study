package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/4 11:54 下午
 * @Version 1.0
 */
public class Offer11 {

    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (i > 0 && numbers[i] < numbers[i - 1]) return numbers[i];
        }
        return numbers[0];
    }
}
