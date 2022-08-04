package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/8/4 11:47 下午
 * @Version 1.0
 */
public class Offer40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }
}
