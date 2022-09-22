package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/9/12 10:36 下午
 * @Version 1.0
 */
public class Offer56I {

    public int[] singleNumbers(int[] nums) {
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }

        // 此时 eor 为两个不同数的异或结果
        // 取出当前数最右边一位1
        int rightOne = eor & (~eor + 1);

        int and = 0;
        for (int num : nums) {
            if ((num & rightOne) != 0) and ^= num;
        }
        return new int[]{and, eor ^ and};
    }
}
