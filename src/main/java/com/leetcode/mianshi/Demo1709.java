package com.leetcode.mianshi;

/**
 * @Author milindeyu
 * @Date 2022/9/28 7:23 下午
 * @Version 1.0
 */
public class Demo1709 {

    public int getKthMagicNumber(int k) {
        int[] memo = new int[k];
        memo[0] = 1;
        int num3 = 0, num5 = 0, num7 = 0;
        int val;
        for (int i = 1; i < k; i++) {
            val = Math.min(Math.min(memo[num3] * 3, memo[num5] * 5), memo[num7] * 7);
            memo[i] = val;
            num3 += val % 3 == 0 ? 1 : 0;
            num5 += val % 5 == 0 ? 1 : 0;
            num7 += val % 7 == 0 ? 1 : 0;
        }
        return memo[k - 1];
    }
}
