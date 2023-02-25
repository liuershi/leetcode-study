package com.leetcode.weekly.week328;

/**
 * @Author milindeyu
 * @Date 2023/1/15 10:30 上午
 * @Version 1.0
 */
public class Demo6291 {

    public int differenceOfSum(int[] nums) {
        int sum = 0, bitSum = 0;
        for (int num : nums) {
            sum += num;
            while (num > 0) {
                bitSum += num % 10;
                num /= 10;
            }
        }
        return Math.abs(sum - bitSum);
    }
}
