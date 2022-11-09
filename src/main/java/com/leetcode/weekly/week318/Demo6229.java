package com.leetcode.weekly.week318;

/**
 * @Author milindeyu
 * @Date 2022/11/6 10:32 上午
 * @Version 1.0
 */
public class Demo6229 {

    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int left = 0, right = 1;
        while (right < n) {
            if (nums[left] == 0 && nums[right] != 0) {
                nums[left] = nums[right];
                nums[right] = 0;
                left++;
                right++;
            } else if (nums[left] == 0){
                right++;
            } else {
                left++;
                right++;
            }
        }
        return nums;
    }
}
