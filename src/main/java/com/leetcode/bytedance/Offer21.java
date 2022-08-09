package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/6 10:12 下午
 * @Version 1.0
 */
public class Offer21 {

    public static int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if ((nums[right] & 1) == 1) {
                while (((nums[left] & 1) == 1)) left++;
                if (left >= right) break;
                nums[left] ^= nums[right];
                nums[right] ^= nums[left];
                nums[left] ^= nums[right];
            }
            right--;
            left++;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1};
        exchange(nums   );
    }
}
