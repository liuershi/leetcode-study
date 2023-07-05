package com.leetcode.top100;

/**
 * @Author milindeyu
 * @Date 2023/6/24 9:38 下午
 * @Version 1.0
 */
public class Demo283 {

    public void moveZeroes(int[] nums) {
        int nowZeroIndex = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[nowZeroIndex++] = num;
            }
        }
        for (int i = nowZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
