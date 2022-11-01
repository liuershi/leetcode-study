package com.leetcode.weekly.week317;

/**
 * @Author milindeyu
 * @Date 2022/10/30 10:31 上午
 * @Version 1.0
 */
public class Demo6220 {

    public int averageValue(int[] nums) {
        int sum = 0, count = 0;
        for (int num : nums) {
            if (num % 3 == 0 && (num & 1) == 0) {
                sum += num;
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }
}
