package com.leetcode.zcy;

import java.util.Arrays;

/**
 * 基数排序
 *
 * @Author milindeyu
 * @Date 2022/3/26 4:55 下午
 * @Version 1.0
 */
public class RadixSortDemo {

    /**
     * 基数排序
     * @param nums
     */
    public static void radixSort(int[] nums) {
        if (nums == null || nums.length < 2) return;

        radixSort(nums, 0, nums.length - 1, getMaxBit(nums));
    }

    /**
     * 实际基数排序实现
     * @param nums 排序数组
     * @param left 待排序数组最左侧下标
     * @param right 待排序数组最右侧下标
     * @param maxBit 数组中最大数的位数（十进制位）
     */
    public static void radixSort(int[] nums, int left, int right, int maxBit) {
        final int radix = 10;

        int i = 0, j = 0;
        int[] bucket = new int[right - left + 1];
        // 循环进出桶的次数
        for (int d = 1; d <= maxBit; d++) {
            int[] count = new int[radix];
            for (i = left; i <= right; i++) {
                j = getDigit(nums[i], d);
                count[j]++;
            }

            for (i = 1; i < radix; i++) {
                count[i] += count[i - 1];
            }

            for (i = right; i >= left; i--) {
                j = getDigit(nums[i], d);
                bucket[--count[j]] = nums[i];
            }

            for (i = left, j = 0; i <= right; i++, j++) {
                nums[i] = bucket[j];
            }
        }
    }

    public static int getDigit(int x, int d) {
        return (x / ((int) Math.pow(10, d - 1))) % 10;
    }

    /**
     * 获取数组中最大数的最大位数，例如最大数位1022，则最大位数位4
     * @param nums
     * @return
     */
    private static int getMaxBit(int[] nums) {
        int maxBit = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        while (max != 0) {
            max /= 10;
            ++maxBit;
        }
        return maxBit;
    }

    public static void main(String[] args) {
        int[] nums = {32, 11, 9, 101, 234, 2031, 54, 19};
        radixSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
