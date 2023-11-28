package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2023/11/10 12:14 上午
 * @Version 1.0
 */
public class Demo2300 {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        int[] ans = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            int left = 0, right = m - 1;
            int min = -1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                long val = (long) spells[i] * potions[mid];
                if (val >= success) {
                    min = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (min != -1) {
                ans[i] = m - min;
            }
        }
        return ans;
    }
}
