package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/12/2 10:50 下午
 * @Version 1.0
 */
public class Demo1769 {

    public int[] minOperations(String boxes) {

        int n = boxes.length();
        int[] res = new int[n];

        int oneBit = 0;
        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                oneBit++;
                res[0] += i;
            }
        }

        int left = 0, right = boxes.charAt(0) == '1' ? oneBit - 1 : oneBit;

        for (int i = 1; i < n; i++) {
            if (boxes.charAt(i - 1) == '1') {
                left++;
            }
            res[i] = res[i - 1] + left - right;
            if (boxes.charAt(i) == '1') {
                right--;
            }
        }

        return res;
    }
}
