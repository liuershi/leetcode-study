package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/13 7:19 下午
 * @Version 1.0
 */
public class Demo258 {

    public int addDigits(int num) {
//        return method01(num);
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    private int method01(int num) {
        if (num < 10) return num;
        int sum = 0;
        for (char c : String.valueOf(num).toCharArray()) {
            sum += c - '0';
        }
        return addDigits(sum);
    }
}
