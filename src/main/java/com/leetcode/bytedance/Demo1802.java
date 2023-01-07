package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/1/4 10:46 下午
 * @Version 1.0
 */
public class Demo1802 {

    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum;
        while (left < right) {
            int mid = left + ((right - left) >> 1) + 1;
            if (sum(mid - 1, index) + sum(mid, n - index) > maxSum) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public long sum(long val, long len) {
        return val >= len ? (val + val - len + 1) * len / 2 : (val + 1) * val / 2 + len - val;
    }

    public static void main(String[] args) {
        Demo1802 demo1802 = new Demo1802();
        System.out.println(demo1802.maxValue(4, 2, 6));
    }
}
