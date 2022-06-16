package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/6/17 12:12 上午
 * @Version 1.0
 */
public class Demo1089 {

    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        if (len == 1) return;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 0 && i < len - 1) {
                for (int j = len - 1; j >= i + 2 ; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[i + 1] = 0;
                i += 1;
            }
        }
    }
}
