package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/1/9 7:33 下午
 * @Version 1.0
 */
public class Demo1806 {

    public int reinitializePermutation(int n) {
        int[] rawNums = new int[n];
        for (int i = 0; i < n; i++) {
            rawNums[i] = i;
        }

        int cnt = 0, half = n >> 1;
        while (true) {
            int[] newNums = new int[n];
            for (int i = 1; i < n; i++) {
                if ((i & 1) == 0) {
                    newNums[i] = rawNums[i >> 1];
                } else {
                    newNums[i] = rawNums[half + ((i - 1) >> 1)];
                }
            }
            rawNums = newNums;
            cnt++;
            if (equalsRawNums(rawNums))
                break;
        }
        return cnt;
    }

    private boolean equalsRawNums(int[] rawNums) {
        for (int i = 1; i < rawNums.length; i++) {
            if (i != rawNums[i])
                return false;
        }
        return true;
    }
}
