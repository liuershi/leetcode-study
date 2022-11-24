package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author milindeyu
 * @Date 2022/11/18 10:29 下午
 * @Version 1.0
 */
public class Demo891 {

    public int sumSubseqWidths(int[] nums) {
        // 思路：将nums排序，然后在指定范围（i, j）内，即最小值num[i]和最最大值nums[j]中，任选其他数字的宽度
        // 都为 num[j] - num[i]，那么在该范围内的宽度之和为：(nums[j] - nums[i]) * (2 ^ (j - i - 1))
        // 因为在[i- 1, j - 1]的范围内存在 2 ^ (j - i - 1)种组合
        Arrays.sort(nums);
        int n = nums.length;
        int divide = (int) 1e9 + 7;

        int[] pows = new int[n];
        pows[0] = 1;
        for (int i = 1; i < n; i++) {
            pows[i] = pows[i - 1] * 2 % divide;
        }
        long rsp = 0;
        for (int i = 0; i < n; i++) {
            long cnt = (long) (pows[i] - pows[n - i - 1]) * nums[i] % divide;
            rsp = (rsp + cnt) % divide;
        }
        return (int) rsp;
    }

    public static void main(String[] args) {
        Demo891 demo891 = new Demo891();
        int[] nums = {5,69,89,92,31,16,25,45,63,40,16,56,24,40,75,82,40,12,50,62,92,44,67,38,92,22,91,24,26,21,100,42,23,56,64,43,95,76,84,79,89,4,16,94,16,77,92,9,30,13};
        System.out.println(demo891.sumSubseqWidths(nums));
    }
}
