package com.leetcode.weekly.yinlian.week293;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-293/problems/maximum-consecutive-floors-without-special-floors/
 *
 * @Author milindeyu
 * @Date 2022/8/10 10:24 下午
 * @Version 1.0
 */
public class Demo2274 {

    public static int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int max = Math.max(special[0] - bottom, top - special[special.length - 1]);
        for (int i = 1; i < special.length; i++) {
            max = Math.max(max, special[i] - special[i - 1] - 1);
            if (i == special.length - 1) {
                max = Math.max(max, top - special[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        maxConsecutive(3, 15, new int[]{7,9,13});
    }
}
