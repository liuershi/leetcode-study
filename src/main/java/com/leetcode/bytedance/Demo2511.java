package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/9/2 6:57 下午
 * @Version 1.0
 */
public class Demo2511 {

    public int captureForts(int[] forts) {
        int len = forts.length;
        int max = 0, prev = -1;
        for (int i = 0; i < len; i++) {
            if (forts[i] == 1 || forts[i] == 0) {
                if (prev != -1 && forts[prev] != forts[i]) {
                    max = Math.max(max, i - prev - 1);
                }
                prev = i;
            }
        }

        return max;
    }
}
