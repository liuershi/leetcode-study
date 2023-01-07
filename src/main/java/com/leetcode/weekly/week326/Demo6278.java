package com.leetcode.weekly.week326;

/**
 * @Author milindeyu
 * @Date 2023/1/1 10:32 上午
 * @Version 1.0
 */
public class Demo6278 {

    public int countDigits(int num) {
        int count = 0;
        for (char c : String.valueOf(num).toCharArray()) {
            if (num % (c - '0') == 0)
                count++;
        }
        return count;
    }
}
