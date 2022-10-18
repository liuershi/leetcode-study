package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/10/18 11:22 下午
 * @Version 1.0
 */
public class Demo643 {

    public double findMaxAverage(int[] nums, int k) {
        // 思路：直接遍历
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int cur = sum;
        for (int i = k; i < nums.length; i++) {
            cur += nums[i] - nums[i - k];
            sum = Math.max(sum, cur);
        }
        // 最后计算的时候才转double，double运算比int慢
        return (double) sum / k;
    }

    public static void main(String[] args) {
        Demo643 demo643 = new Demo643();
        System.out.println(demo643.findMaxAverage(new int[]{0, 4, 0, 3, 2}, 1));
    }
}
