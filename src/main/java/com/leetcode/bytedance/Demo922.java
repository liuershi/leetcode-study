package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/12/11 9:53 下午
 * @Version 1.0
 */
public class Demo922 {

    public int[] sortArrayByParityII(int[] nums) {
        int j = 1;
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            if ((nums[i] & 1) != 0) {
                while((nums[j] & 1) != 0) {
                    j += 2;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
}
