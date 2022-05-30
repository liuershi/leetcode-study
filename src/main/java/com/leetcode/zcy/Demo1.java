package com.leetcode.zcy;

import java.util.Arrays;

/**
 *
 * @Author milindeyu
 * @Date 2022/3/25 9:12 下午
 * @Version 1.0
 */
public class Demo1 {

    /**
     * 当前数组中存在一个数个数为奇数，其他数个数都为偶数，找到这个数
     * @param nums
     * @return
     */
    public static int obtainOdd(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    /**
     * 当前数组中存在两个数个数为奇数位，其他数都为偶数为，请找出这两个数
     * @param nums
     * @return
     */
    public static int[] obtainOddTwo(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        int[] res = new int[2];
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }
        // 假如，这两个数为a、b，此时 eor = a ^ b，由于是两个数，所以 a != b
        // 可以肯定，eor所有位中存在至少一位为1
        int rightOne = eor & (~eor + 1); // 取最右边位为1的值

        // 由于rightOne为1，所以此时a和b该位上的值肯定不同，按这个位将a和b分开
        int eor1 = 0;
        for (int num : nums) {
            if ((num & rightOne) == 0) {
                eor1 ^= num;
            }
        }
        int a = eor ^ eor1;
        int b = a ^ eor;
        res[0] = a;
        res[1] = b;
        return res;
    }

    /**
     * 冒泡排序
     * @param nums
     */
    public static void bubblingSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j])
                    swap(nums, i, j);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 4, 4, 4, 4, 3};
        System.out.println(obtainOdd(nums));

        int[] numTwo = {1, 2, 3, 2, 4, 4, 4, 4, 3, 2};
        System.out.println(Arrays.toString(obtainOddTwo(numTwo)));

        int[] sort = {4, 6, 1, 3, 9, 4, 5, 2};
        bubblingSort(sort);
        System.out.println(Arrays.toString(sort));
    }
}
