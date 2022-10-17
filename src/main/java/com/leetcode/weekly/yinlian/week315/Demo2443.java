package com.leetcode.weekly.yinlian.week315;

/**
 * @Author milindeyu
 * @Date 2022/10/17 10:27 下午
 * @Version 1.0
 */
public class Demo2443 {

    public boolean sumOfNumberAndReverse(int num) {
        int mid = num / 2;
        int left = mid, right = num - mid;
        while (left >= 0 && right <= num) {
            if (isValid(left, right)) return true;
            left--;
            right++;
        }
        return false;
    }

    private boolean isValid(int left, int right) {
        return left == Integer.parseInt(new StringBuilder().append(right).reverse().toString());
    }
}
