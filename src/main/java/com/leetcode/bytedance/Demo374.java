package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/18 10:53 下午
 * @Version 1.0
 */
public class Demo374 {

    public int guessNumber(int n) {
        int left = 0, right = n;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int guess = guess(middle);
            if (guess == 0) return middle;
            else if (guess > 0) left = middle + 1;
            else right = middle - 1;
        }
        return -1;
    }

    public int guess(int num) {
        return num;
    }
}
