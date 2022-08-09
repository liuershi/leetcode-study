package com.leetcode.bytedance;

/**
 * 最大连续 1 的个数
 *
 * @Author milindeyu
 * @Date 2022/7/30 4:46 下午
 * @Version 1.0
 */
public class Demo485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int num : nums) {
            if (num == 1) count++;
            else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
