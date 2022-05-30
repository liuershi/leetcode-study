package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/23 10:21 下午
 * @Version 1.0
 */
public class Demo69 {

    public int mySqrt(int x) {
        if (x <= 1)
            return x;

        int left = 0, right = x;
        while (right > left + 1) {
            int middle = (left + right) / 2;
            if (x / middle < middle)
                right = middle;
            else
                left = middle;
        }
        return left;
    }
}
