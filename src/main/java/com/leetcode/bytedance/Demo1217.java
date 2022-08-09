package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/8 10:39 下午
 * @Version 1.0
 */
public class Demo1217 {

    public int minCostToMoveChips(int[] position) {
        if (position == null || position.length < 2) return 0;
        int even = 0, odd = 0;
        for (int num : position) {
            if ((num & 1) != 0) odd++;
            else even++;
        }
        return Math.min(even, odd);
    }
}
