package com.leetcode.bytedance;

import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2023/3/6 12:54 上午
 * @Version 1.0
 */
public class Demo1653 {

    public int minimumDeletions(String s) {
        int countB = 0, dp = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                dp = Math.min(dp + 1, countB);
            } else {
                countB++;
            }
        }
        return dp;
    }
}
