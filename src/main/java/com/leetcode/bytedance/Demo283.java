package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/13 10:37 下午
 * @Version 1.0
 */
public class Demo283 {

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int nowZeroIndex = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[nowZeroIndex++] = nums[i];
            }
        }
        for (int i = nowZeroIndex; i < len; i++) {
            nums[i] = 0;
        }
    }
}
