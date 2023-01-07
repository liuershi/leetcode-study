package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/1/6 10:16 下午
 * @Version 1.0
 */
public class Demo2180 {

    public int countEven(int num) {
        int count = 0;
        while (num > 1) {
            int val = num, sum = 0;
            while (val > 0) {
                sum += val % 10;
                val /= 10;
            }
            if ((sum & 1) == 0)
                count++;
            num--;
        }
        return count;
    }
}
